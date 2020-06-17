package jcolonia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author victo
 * Escribe en un documento los resultados deseados
 */
public class Persistencia {
	
	private File fichero;
	
	public Persistencia(File fichero) {
		this.fichero=fichero;
	}
	
	public void guardar(List<Apuesta> apuestas) {
		try {
			FileWriter fw = new FileWriter(fichero);
			for(Apuesta a: apuestas) {
				fw.write(a.toString() + "\n");
			}
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Se importa las apuestas del documento
	 * @return
	 */
	public List<Apuesta> leer() {
		List<Apuesta> apuestas= new ArrayList<>();
		String linea;
		String local;
		String visitante;
		String opcion;
		String[] conjunto;
		
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader buffer=new BufferedReader(fr);
			while((linea=buffer.readLine())!=null) {
				conjunto=linea.split("-");
				local=conjunto[0];
				visitante=conjunto[1].split(" ")[0];
				opcion=conjunto[1].split(" ")[1];
				apuestas.add(new Apuesta(local, visitante, opcion));
			}
			buffer.close();
			fr.close();
		}catch(FileNotFoundException e){
			System.err.println("Archivo no encontrado.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return apuestas;
	}
}
