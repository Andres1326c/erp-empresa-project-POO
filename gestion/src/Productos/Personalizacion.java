package Productos;
//aAqui vamos a hacer como tal la interfaz con la que interatua el cliente
// toca poner: que registre que tipo de personalizacion quire, por ejemplo dtf, sublimacion etc
//  Que personalizacion como tal quiere, diseno, mensje, letras
// debe calcular que costo adicional tiene el diseno y los materiales de personalizacion
// a futuro quiza para las imagenes de referencia o que envie el cliente
// a futuro quiza un kanban de estado de diseno donde se ponga en que fase del diseno va y cuano o que falta
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

    private tipoTecnica tecnica;
    private tipoContenido contenido;
    private kanban estadoDiseno;
    private String tema;
    private double costo;
    private TamanoPreferido tamano;

    public Personalizacion(tipoTecnica tecnica, tipoContenido contenido, String tema, TamanoPreferido tamano) {
        this.tecnica = tecnica;
        this.contenido = contenido;
        this.tema = tema;
        this.estadoDiseno = kanban.PENDIENTE;
        this.tamano = tamano;
        this.costo = calcularCostosIniciales(this.tecnica, this.contenido, this.tamano);
    }

    private double calcularCostosIniciales(tipoTecnica tecnica, tipoContenido contenido, TamanoPreferido tamano) {
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
        this.costo = calcularCostosIniciales(this.tecnica, this.contenido, this.tamano);

    }
    public void establecerTamano(TamanoPreferido tamano){
        this.tamano = tamano;
        this.costo = calcularCostosIniciales(this.tecnica, this.contenido, this.tamano);

    }
    public tipoContenido obtenerCOntenido(){return contenido;}
    public String obtenerTema(){return tema;}
    public kanban obtenerEstadoDiseno(){
        return estadoDiseno;
    }
    public TamanoPreferido obtenerTamano(){return tamano;}
    public void establecerEstadoDiseno(kanban estado){this.estadoDiseno = estado;}
}