package jcolonia;
/**
 * @author victor
 * Almacena una apuesta
 */
public class Apuesta {
	
	/**
	 * Se especifican los equipos y el resultado
	 */
	private String local;
	private String visitante;
	private Opcion resultado;
	
	public String getLocal() {
		return local;
	}

	public String getVisitante() {
		return visitante;
	}

	public Opcion getResultado() {
		return resultado;
	}

	/**
	 * Constructor de un partido y su resultado con: 
	 * @param local
	 * @param visitante
	 * @param resultado
	 */
	public Apuesta(String local, String visitante, Opcion resultado) {
		this.local=local;
		this.visitante=visitante;
		this.resultado=resultado;
	}
	/**
	 * segundo constructor
	 * @param local
	 * @param visitante
	 * @param resultado
	 */
	public Apuesta(String local, String visitante, String resultado) {
		this.local=local;
		this.visitante=visitante;
		this.resultado=asignarOpcion(resultado);
	}
	/**
	 *Se asigna una opcion
	 */
	private Opcion asignarOpcion(String resultado) {
		try {
			if(!resultado.equals("1") && !resultado.equals("2") && !resultado.equals("x") && !resultado.equals("X"))
				throw new Exception("Opcion no valida");
			Opcion opcionEnum=null;
			switch(resultado) {
				case "1": opcionEnum=Opcion.UNO;
					     	break;
				case "2": opcionEnum=Opcion.DOS;
			     			break;
				case "X": opcionEnum=Opcion.X;
			     			break;
				case "x": opcionEnum=Opcion.X;
			     			break;
			}
			return opcionEnum;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Método to String 
	 */
	@Override
	public String toString() {
		return local + "-" + visitante + " " + resultado.getOpcion();
	}
}
