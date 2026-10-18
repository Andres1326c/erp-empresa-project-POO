public class Cierre {
    private int totalPedidos;
    private int totalUnidades;
    private double totalVendido;
    private double totalDescuentos;
    private double totalRecargos;
    private double pedidoMayor;

    public Cierre() {
        totalPedidos = 0;
        totalUnidades = 0;
        totalVendido = 0;
        totalDescuentos = 0;
        totalRecargos = 0;
        pedidoMayor = 0;
    }

    // Variables acumuladoras
    public void registrar(Pedido pedido) {
        totalPedidos++;
        totalUnidades = totalUnidades + pedido.getCantidad();
        totalVendido = totalVendido + pedido.getTotal();
        totalDescuentos = totalDescuentos + pedido.getDescuento();
        totalRecargos = totalRecargos + pedido.getRecargo();
        if (pedido.getTotal() > pedidoMayor) {
            pedidoMayor = pedido.getTotal();
        }
    }

    public int getTotalPedidos() { 
        return totalPedidos; 
    }
    public int getTotalUnidades() { 
        return totalUnidades; 
    }
    public double getTotalVendido() { 
        return totalVendido; 
    }
    public double getTotalDescuentos() { 
        return totalDescuentos; 
    }
    public double getTotalRecargos() { 
        return totalRecargos; 
    }
    public double getPedidoMayor() { 
        return pedidoMayor; 
    }

    public String toString() {
        String resumen = "\n********* CIERRE DEL DÍA ********\n"
            + "Pedidos realizados: " + totalPedidos + "\n"
            + "Unidades vendidas: " + totalUnidades + "\n"
            + "Total vendido: $" + totalVendido + "\n"
            + "Descuentos otorgados: $" + totalDescuentos + "\n"
            + "Recargos cobrados: $" + totalRecargos + "\n"
            + "Pedido más grande: $" + pedidoMayor + "\n";
        if (totalPedidos > 0) {
            resumen = resumen + "Promedio por pedido: $" + (totalVendido / totalPedidos) + "\n";
        }
        resumen = resumen + "**********";
        return resumen;
    }
}
