package Inventario;
import Productos.Producto;
import Entidades.Proveedor;
public class Inventario {
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private Producto producto5;
    private Producto producto6;
    private Producto producto7;
    private Producto producto8;
    private int cantidadProductos;
    private Proveedor proveedor;

    public Inventario() {
        producto1 = null;
        producto2 = null;
        producto3 = null;
        producto4 = null;
        producto5 = null;
        producto6 = null;
        producto7 = null;
        producto8 = null;
        cantidadProductos = 0;
        proveedor = null;
    }

    public boolean hayEspacio() {
        return cantidadProductos < 8;
    }

    // Guarda el producto en la primera variable libre
    public void agregarProducto(Producto producto) {
        if (cantidadProductos == 0) {
            producto1 = producto;
        } else if (cantidadProductos == 1) {
            producto2 = producto;
        } else if (cantidadProductos == 2) {
            producto3 = producto;
        } else if (cantidadProductos == 3) {
            producto4 = producto;
        } else if (cantidadProductos == 4) {
            producto5 = producto;
        } else if (cantidadProductos == 5) {
            producto6 = producto;
        } else if (cantidadProductos == 6) {
            producto7 = producto;
        } else if (cantidadProductos == 7) {
            producto8 = producto;
        }

        cantidadProductos++;
    }

    public Producto obtenerProducto(int numero) {
        Producto resultado = null;
        switch (numero) {
            case 1: resultado = producto1; break;
            case 2: resultado = producto2; break;
            case 3: resultado = producto3; break;
            case 4: resultado = producto4; break;
            case 5: resultado = producto5; break;
            case 6: resultado = producto6; break;
            case 7: resultado = producto7; break;
            case 8: resultado = producto8; break;
        }
        return resultado;
    }

    public boolean hayDisponibilidad(int numero, int cantidad) {
        boolean disponible = false;
        Producto p = obtenerProducto(numero);
        if (p != null) {
            disponible = p.hayStock(cantidad);
        }
        return disponible;
    }

    public void actualizarExistencias(int numero, int cantidad) {
        Producto p = obtenerProducto(numero);
        if (p != null) {
            p.descontarStock(cantidad);
        }
    }

    public int getCantidadProductos() { return cantidadProductos; }

    public Producto getProducto1() { return producto1; }
    public Producto getProducto2() { return producto2; }
    public Producto getProducto3() { return producto3; }
    public Producto getProducto4() { return producto4; }
    public Producto getProducto5() { return producto5; }
    public Producto getProducto6() { return producto6; }
    public Producto getProducto7() { return producto7; }
    public Producto getProducto8() { return producto8; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public String toString() {
        String texto = "";
        if (producto1 != null) {
            texto = texto + "1. " + producto1 + "\n";
        }
        if (producto2 != null) {
            texto = texto + "2. " + producto2 + "\n";
        }
        if (producto3 != null) {
            texto = texto + "3. " + producto3 + "\n";
        }
        if (producto4 != null) {
            texto = texto + "4. " + producto4 + "\n";
        }
        if (producto5 != null) {
            texto = texto + "5. " + producto5 + "\n";
        }
        if (producto6 != null) {
            texto = texto + "6. " + producto6 + "\n";
        }
        if (producto7 != null) {
            texto = texto + "7. " + producto7 + "\n";
        }
        if (producto8 != null) {
            texto = texto + "8. " + producto8 + "\n";
        }

        return texto;
    }
}
