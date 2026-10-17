package Productos;
//aAqui vamos a hacer como tal la interfaz con la que interatua el cliente
// toca poner: que registre que tipo de personalizacion quire, por ejemplo dtf, sublimacion etc
//  Que personalizacion como tal quiere, diseno, mensje, letras
// debe calcular que costo adicional tiene el diseno y los materiales de personalizacion
// a futuro quiza para las imagenes de referencia o que envie el cliente
// a futuro quiza un kanban de estado de diseno donde se ponga en que fase del diseno va y cuano o que falta
public class Personalizacion {

public enum tipoTecnica{
    DTF,
    SUBLIMACION,
    BORDADO,
    SERIGRAFIA;

}
public enum tipoContenido{
DISENO_PROPIO, MENSAJE, LOGO;

}
public enum kanban{

    PENDIENTE,
    EN_DISENO,
    ESPERANDO_APROBACION,
    APROBADO;
}
private tipoTecnica tipoTecnica;
private tipoContenido tipoContenido;
private kanban kanban;

public Personalizacion(tipoTecnica tipoTecnica, tipoContenido tipoContenido,String temaContenido){
this.tipoTecnica = tipoTecnica;
this.tipoContenido = tipoContenido;
this.temaContenido = temaContenido;

this.estadodiseno = kanban.PENDIENTE;

}



}
