public class Pedido {
    private Cliente cliente;                  
    private Producto producto;                
    private Personalizacion personalizacion;  
    private int cantidad;
    private boolean urgente;
    private double subtotal;
    private double descuento;
    private double recargo;
    private double total;

    public Pedido(Cliente cliente, Producto producto, Personalizacion personalizacion,
                  int cantidad, boolean urgente) {
        this.cliente = cliente;
        this.producto = producto;
        this.personalizacion = personalizacion;
        this.cantidad = cantidad;
        this.urgente = urgente;
    }

   
    public void calcularTotal() {
        subtotal = (producto.getPrecioBase() + personalizacion.getCostoPorUnidad()) * cantidad;

        int porcentajeDescuento = 0;
        if (cantidad >= 10) {
            porcentajeDescuento = 15;
        } else if (cantidad >= 5) {
            porcentajeDescuento = 10;
        }
        if (cliente.isFrecuente()) {
            porcentajeDescuento = porcentajeDescuento + 5;
        }
        descuento = subtotal * porcentajeDescuento / 100;

        recargo = 0;
        if (urgente) {
            recargo = (subtotal - descuento) * 20 / 100;
        }

        total = subtotal - descuento + recargo;
    }

    public Cliente getCliente() { 
        return cliente; 
    }
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public Producto getProducto() { 
        return producto; 
    }
    public void setProducto(Producto producto) { 
        this.producto = producto; 
    }

    public Personalizacion getPersonalizacion() { 
        return personalizacion; 
    }
    public void setPersonalizacion(Personalizacion personalizacion) { 
        this.personalizacion = personalizacion; 
    }

    public int getCantidad() { 
        return cantidad;
    }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
    }

    public boolean isUrgente() { 
        return urgente; 
    }
    public void setUrgente(boolean urgente) { 
        this.urgente = urgente; 
    }

    public double getSubtotal() { 
        return subtotal; 
    }
    public double getDescuento() { 
        return descuento; 
    }
    public double getRecargo() { 
        return recargo; 
    }
    public double getTotal() { 
        return total; 
    }

    public String toString() {
        return "\n ******** PEDIDO ********\n"
             + "Cliente: " + cliente + "\n"
             + "Producto: " + producto.getNombre() + " x" + cantidad + "\n"
             + personalizacion + "\n"
             + "Subtotal: $" + subtotal + "\n"
             + "Descuento: - $" + descuento + "\n"
             + "Recargo urgente: + $" + recargo + "\n"
             + "TOTAL: $" + total + "\n"
             + "**********************";
    }
}
