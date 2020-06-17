package jcolonia;

/**
 * Opciones del resultado del partido.
 * @author victo
 */
public enum Opcion {

    UNO("1"),
    X("x"),
    DOS("2");

    private String opcion;
    /**
     * constructor
     * @param opcion
     */
    Opcion(String opcion){
        this.opcion = opcion;
    }
    public String getOpcion() {
        return opcion;
    }
}