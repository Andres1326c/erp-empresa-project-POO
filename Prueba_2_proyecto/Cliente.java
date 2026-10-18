public class Cliente {
    private String nombre;
    private String telefono;
    private boolean frecuente;

    public Cliente(String nombre, String telefono, boolean frecuente) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.frecuente = frecuente;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getTelefono() { 
        return telefono; 
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono; 
    }

    public boolean isFrecuente() { 
        return frecuente; 
    }
    public void setFrecuente(boolean frecuente) { 
        this.frecuente = frecuente; 
    }

    public String toString() {
        String texto = nombre + " (Tel: " + telefono + ")";
        if (frecuente) {
            texto = texto + " - Cliente frecuente";
        }
        return texto;
    }
}
