import java.util.Scanner;

public class Tienda {
    private Scanner sc;
    private Producto taza;
    private Producto cartuchera;
    private Producto monedero;
    private Producto agenda;
    private Cliente clienteActual;
    private Pedido ultimoPedido;
    private Cierre cierre;

    public Tienda() {
        sc = new Scanner(System.in);
        taza = new Producto("Taza",10000,50);
        cartuchera = new Producto("Cartuchera", 10000, 50);
        monedero = new Producto("Monedero", 20000, 50);
        agenda = new Producto("Agenda", 15000, 50);
        clienteActual = null;
        ultimoPedido = null;
        cierre = new Cierre();
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 5) {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    hacerPedido();
                    break;
                case 3:
                    verUltimoPedido();
                    break;
                case 4:
                    mostrarCatalogo();
                    break;
                case 5:
                    System.out.println("Cerrando la jornada.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println(cierre);
    }

    private void mostrarMenu() {
        System.out.println("\n--- REGALOS PERSONALIZADOS ---");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Hacer pedido");
        System.out.println("3. Ver último pedido");
        System.out.println("4. Ver catálogo");
        System.out.println("5. Salir y cerrar el día");
    }

    private void mostrarCatalogo() {
        System.out.println("\n--- CATÁLOGO ---");
        System.out.println("1. " + taza);
        System.out.println("2. " + cartuchera);
        System.out.println("3. " + monedero);
        System.out.println("4. " + agenda);
    }

    private void registrarCliente() {
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        while (nombre.length() == 0) {
            System.out.println("El nombre no puede estar vacío.");
            System.out.print("Nombre del cliente: ");
            nombre = sc.nextLine();
        }
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("¿Es cliente frecuente? (s/n): ");
        String respuesta = sc.nextLine();
        boolean frecuente = false;
        if (respuesta.equals("s") || respuesta.equals("S")) {
            frecuente = true;
        }
        clienteActual = new Cliente(nombre, telefono, frecuente);
        System.out.println("Cliente registrado: " + clienteActual);
    }

    private void hacerPedido() {
        if (clienteActual == null) {
            System.out.println("Primero registra un cliente (opción 1).");
        } else {
            mostrarCatalogo();
            Producto elegido = null;
            while (elegido == null) {
                System.out.print("Producto (1-4): ");
                int op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1: 
                    elegido = taza; 
                        break;
                    case 2: 
                    elegido = cartuchera; 
                        break;
                    case 3: 
                    elegido = monedero; 
                        break;
                    case 4: 
                    elegido = agenda;
                        break;
                    default: 
                    System.out.println("Producto no válido.");
                }
            }

            // Regla: límite de cantidad por pedido
            System.out.print("Cantidad (1 a 50): ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            while (cantidad < 1 || cantidad > 50) {
                System.out.println("La cantidad debe estar entre 1 y 50.");
                System.out.print("Cantidad (1 a 50): ");
                cantidad = sc.nextInt();
                sc.nextLine();
            }

            if (elegido.hayStock(cantidad)) {
                Personalizacion pers = crearPersonalizacion();
                System.out.print("¿Entrega urgente? (+20%) (s/n): ");
                String respuesta = sc.nextLine();
                boolean urgente = false;
                if (respuesta.equals("s") || respuesta.equals("S")) {
                    urgente = true;
                }

                Pedido pedido = new Pedido(clienteActual, elegido, pers, cantidad, urgente);
                pedido.calcularTotal();
                elegido.descontarStock(cantidad);
                ultimoPedido = pedido;
                cierre.registrar(pedido);

                System.out.println(pedido);
            } else {
                System.out.println("Stock insuficiente. Disponible: " + elegido.getStock());
            }
        }
    }

    private Personalizacion crearPersonalizacion() {
        System.out.print("Personalización: 1) Texto ($5000 c/u)  2) Imagen ($8000 c/u)  3) Ninguna: ");
        int tipo = sc.nextInt();
        sc.nextLine();
        while (tipo < 1 || tipo > 3) {
            System.out.println("Opción no válida.");
            System.out.print("Personalización (1-3): ");
            tipo = sc.nextInt();
            sc.nextLine();
        }

        Personalizacion p;
        switch (tipo) {
            case 1:
                System.out.print("Texto a imprimir : ");
                String texto = sc.nextLine();
                
                p = new Personalizacion("Texto", texto, 5000);
                break;
            case 2:
                System.out.print("Nombre del archivo o descripción de la imagen: ");
                String imagen = sc.nextLine();
                p = new Personalizacion("Imagen", imagen, 8000);
                break;
            default:
                p = new Personalizacion("Ninguna", "-", 0);
        }
        return p;
    }

    private void verUltimoPedido() {
        if (ultimoPedido == null) {
            System.out.println("Todavía no hay pedidos.");
        } else {
            System.out.println(ultimoPedido);
        }
    }
}
