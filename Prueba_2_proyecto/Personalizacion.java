public class Personalizacion {
    private String tipo;          
    private String contenido;
    private double costoPorUnidad;

    public Personalizacion(String tipo, String contenido, double costoPorUnidad) {
        this.tipo = tipo;
        this.contenido = contenido;
        this.costoPorUnidad = costoPorUnidad;
    }

    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }

    public String getContenido() { 
        return contenido; 
    }
    public void setContenido(String contenido) { 
        this.contenido = contenido; 
    }

    public double getCostoPorUnidad() { 
        return costoPorUnidad; 
    }
    public void setCostoPorUnidad(double costoPorUnidad) { 
        this.costoPorUnidad = costoPorUnidad; 
    }

    public String toString() {
        String texto;
        if (tipo.equals("Ninguna")) {
            texto = "Sin personalización";
        } else {
            texto = tipo + ": " + contenido + " (+$" + costoPorUnidad + " c/u)";
        }
        return texto;
    }
}
