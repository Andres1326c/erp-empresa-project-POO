package Productos;

public class Personalizacion {

    public enum tipoTecnica {
        DTF,
        SUBLIMACION,
        BORDADO,
        SERIGRAFIA;

    }

    public enum tipoContenido {
        DISENO_PROPIO, MENSAJE, LOGO;

    }

    public enum kanban {

        PENDIENTE,
        EN_DISENO,
        ESPERANDO_APROBACION,
        APROBADO;
    }

    public enum TamanoPreferido {
        PEQUENO, MEDIANO, GRANDE;

    }
public enum servicioDiseno {LISTO_DE_ClIENTE, MODIFICACION, DISENO_COMPLETO;
}

    private tipoTecnica tecnica;
    private tipoContenido contenido;
    private kanban estadoDiseno;
    private String tema;
    private double costo;
    private TamanoPreferido tamano;
    private servicioDiseno diseno;
    private String archivoCliente;
private static final double costoDisenoCompleto = 20000;
private static final double costoModificarDiseno = 8000;

    public Personalizacion(tipoTecnica tecnica, tipoContenido contenido, String tema, TamanoPreferido tamano, servicioDiseno diseno, String archivoCliente)  {
        this.tecnica = tecnica;
        this.contenido = contenido;
        this.tema = tema;
        this.estadoDiseno = kanban.PENDIENTE;
        this.tamano = tamano;
        this.diseno = diseno;
        this.archivoCliente = archivoCliente;
        this.costo = costoTotal();

    }

    private double calcularCostoTecnica() {
        double costo = 0;
        if (tecnica == tipoTecnica.DTF) {
            if (tamano == TamanoPreferido.PEQUENO) {
                costo = 25000;
            } else if (tamano == TamanoPreferido.MEDIANO) {
                costo = 18000;
            } else {
                costo = 12000;
            }
        } else if (tecnica == tipoTecnica.SUBLIMACION) {

            if (tamano == TamanoPreferido.GRANDE) {
                costo = 15000;
            } else {
                costo = 9000;
            }

        } else if (tecnica == tipoTecnica.BORDADO) {

            if (tamano == TamanoPreferido.GRANDE) {
                costo = 35000;
            } else if (tamano == TamanoPreferido.MEDIANO) {
                costo = 26000;
            } else {
                costo = 16000;
            }
        } else if (tecnica == tipoTecnica.SERIGRAFIA) {

            if (tamano == TamanoPreferido.GRANDE) {
                costo = 20000;
            } else if (tamano == TamanoPreferido.MEDIANO) {
                costo = 14000;
            } else {
                costo = 8000;
            }
        }return costo;
    }
    public double obtenerCosto(){
        return this.costo;
    }

    public tipoTecnica obtenerTecnica(){
        return tecnica;
    }
    public void establecerTecnica(tipoTecnica tecnica){
        this.tecnica = tecnica;
        this.costo = costoTotal();

    }
    public void establecerTamano(TamanoPreferido tamano){
        this.tamano = tamano;
        this.costo = costoTotal();

    }

    public void establecerEstadoDiseno(kanban estado){this.estadoDiseno = estado;}
private double costoDiseno(){

        if(diseno == servicioDiseno.DISENO_COMPLETO) {
            return costoDisenoCompleto;
        }else if(diseno == servicioDiseno.MODIFICACION){
            return costoModificarDiseno;
        }
        return 0;
}
private double costoTotal(){
        return calcularCostoTecnica() + costoDiseno();
}
public void cambioKanban(){
       if(estadoDiseno == kanban.PENDIENTE) {
           if (diseno == servicioDiseno.LISTO_DE_ClIENTE) {
               estadoDiseno = kanban.APROBADO;
           } else {
               estadoDiseno = kanban.EN_DISENO;
           }}
else if (estadoDiseno == kanban.EN_DISENO) {
estadoDiseno = kanban.ESPERANDO_APROBACION;
           } else if (estadoDiseno == kanban.APROBADO){

       }else if (estadoDiseno == kanban.ESPERANDO_APROBACION){
    estadoDiseno = kanban.APROBADO;
       }
}

    public tipoTecnica getTecnica() {
        return tecnica;
    }
    public double getCosto() {
        return costo;
    }
    public String getTema() {
        return tema;
    }
    public TamanoPreferido getTamano() {
        return tamano;
    }
    public servicioDiseno getDiseno() {
        return diseno;
    }
    public kanban getEstadoDiseno() {
        return estadoDiseno;
    }
    public String getArchivoCliente() {
        return archivoCliente;
    }
}