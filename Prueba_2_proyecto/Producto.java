public class Producto {
    private String nombre;
    private double precioBase;
    private int stock;

    public Producto(String nombre, double precioBase, int stock) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public double getPrecioBase() { 
        return precioBase; 
    }
    public void setPrecioBase(double precioBase) { 
        this.precioBase = precioBase; 
    }

    public int getStock() { 
        return stock; 
    }
    public void setStock(int stock) { 
        this.stock = stock; 
    }

    public boolean hayStock(int cantidad) {
        return cantidad <= stock;
    }

    public void descontarStock(int cantidad) {
        stock = stock - cantidad;
    }

    public String toString() {
        return nombre + " - $" + precioBase + " (stock: " + stock + ")";
    }
}
