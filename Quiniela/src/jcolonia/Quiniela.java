package jcolonia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Es una quiniela
 * @author victo
 *
 */
public class Quiniela {

	private List<Apuesta> apuestas;
	private Scanner sc;
	private Persistencia persistencia;

	/**
	 * constructor
	 * 
	 * @return
	 */
	public Quiniela() {
		apuestas = new ArrayList<>();
		sc = new Scanner(System.in);
		persistencia = new Persistencia(new File("./Quiniela.txt"));
	}

	/**
	 * se muestran las posibles opciones
	 */
	public void menu() {
		int opcion;
		while (true) {
			System.out.println("Gestor de quinielas.");
			System.out.println("Seleccione lo que quiere hacer: ");
			System.out.println("1.Introducir una nueva apuesta.");
			System.out.println("2.Leer todas las apuestas.");
			System.out.println("3.Importar las apuestas.");
			System.out.println("4.Exportar las apuestas.");
			System.out.println();
			System.out.println("0.Salir");

			opcion = pedirOpcion();
			recogeOpcion(opcion);
		}
	}

	/**
	 * se recoge la opcion del usuario
	 * 
	 * @return
	 */
	private int pedirOpcion() {
		boolean correcto = false;
		int opcion = 0;
		while (!correcto) {
			System.out.println("Introduzca la opcion: ");
			
			if (sc.hasNext()) {
				opcion = sc.nextInt();
				
				sc.nextLine();
			}
			if (opcion >= 0 && opcion < 5) {
				correcto = true;
			} else
				System.out.println("Valor incorrecto.");
		}
		return opcion;
	}

	/**
	 * se recoge la opcion elegida por el usuario
	 */
	private void recogeOpcion(int opcion) {
		switch (opcion) {
		case 1:
			introducirApuesta();
			break;
		case 2:
			imprimirApuestas();
			break;
		case 3:
			importar();
			break;
		case 4:
			exportar();
			break;
		case 0:
			System.exit(0);
			break;

		}
	}
	/**
	 * se introduce la apuesta del partido
	 */
	private void introducirApuesta() {
		String local = "";
		String visitante = "";
		String opcion = "";
		Apuesta apuesta;

		System.out.println("Introduce equipo local: ");
		local = introducirPalabra();

		System.out.println("Introduce equipo visitante: ");
		visitante = introducirPalabra();

		opcion = introducirOpcion();

		apuesta = new Apuesta(local, visitante, opcion);

		apuestas.add(apuesta);
	}
	
	/**
	 * para escribir las palabras
	 * @return
	 */
	private String introducirPalabra() {
		String palabra = "";

		if (sc.hasNext()) {
			palabra = sc.nextLine();
			
			sc.nextLine();
		}
		return palabra;
	}
	
	/**
	 * se introduce la opción de la apuesta
	 * @return
	 */
	private String introducirOpcion() {
		boolean correcto = false;
		String opcion = "";

		while (!correcto) {
			System.out.println("Introducir la opcion (1, 2, X): ");
			opcion = introducirPalabra();

			if (opcion.equals("1") || opcion.equals("2") || opcion.equals("x") || opcion.equals("X")) {
				correcto = true;
			} else {
				System.out.println("Valor incorrecto.");
			}
		}
		return opcion;
	}
	
	/**
	 * muestra las apuestas
	 */
	private void imprimirApuestas() {
		for (Apuesta a : apuestas) {
			System.out.println(a.toString());
		}
	}
	
	/**
	 * se importan los datos del documento a el programa
	 */
	private void importar() {
		apuestas = persistencia.leer();
	}
	
	/**
	 * se guardan las apuestas escritas en el documento
	 */
	private void exportar() {
		persistencia.guardar(apuestas);
	}

}
