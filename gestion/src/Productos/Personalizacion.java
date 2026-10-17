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
private tipoTecnica tecnica;
private tipoContenido contenido;
private kanban estadoDiseno;
private String tema;
private double costoInicial;

public Personalizacion(tipoTecnica tecnica, tipoContenido contenido ,String tema){
this.tecnica = tecnica;
this.contenido = contenido;
this.tema = tema;
this.estadoDiseno = kanban.PENDIENTE;
this.costoInicial= calcularCostosIniciales(this.tecnica, this.contenido);
}
private double calcularCostosIniciales(tipoTecnica tecnica,tipoContenido contenido){
   double costo = 0;
    if(tecnica == tipoTecnica.DTF){return costo += 3000;}
    else if(tecnica == tipoTecnica.SUBLIMACION){return costo += 2000;}
    else if(tecnica == tipoTecnica.BORDADO){return costo += 10000;}
    else if (tecnica == tipoTecnica.SERIGRAFIA){return costo += 1500;}
    return costo;
}


}
