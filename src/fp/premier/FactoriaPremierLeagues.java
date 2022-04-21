package fp.premier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoriaPremierLeagues {
	
	/* Metodo para lectura de CSV */
	public static List<List<String>> readCSV(String url) {
		List<List<String>> elements = new ArrayList<>();
		
		// Leemos el CSV al completo
		try (BufferedReader br = new BufferedReader(new FileReader(url))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				elements.add(Arrays.asList(values));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Eliminamos el primer elemento porque es la cabecera del CSV
		elements.remove(0);
		
		return elements;
	}
	
	/* Método que recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y 
	devuelve un objeto del tipo a partir de esa cadena.*/
	public static PremierLeague parsearPremierLeague(List<String> premierCSV) {
		
		String temporada = premierCSV.get(0);
		Instant hora = Instant.parse(premierCSV.get(1));
		String local = premierCSV.get(2);
		String visitante = premierCSV.get(3);
		Integer golesLocal = Integer.parseInt(premierCSV.get(4));
		Integer golesVisitante = Integer.parseInt(premierCSV.get(5));
		Resultado resultado = Resultado.valueOf(premierCSV.get(6));
		Integer golesLocalDescanso = Integer.parseInt(premierCSV.get(7));
		Integer golesVisitanteDescanso = Integer.parseInt(premierCSV.get(8));
		Resultado resuladoDescanso = Resultado.valueOf(premierCSV.get(9));
		String arbitro  = premierCSV.get(10);
		Integer amarillasLocal = Integer.parseInt(premierCSV.get(11));
		Integer amarillasVisitante = Integer.parseInt(premierCSV.get(12));
		Integer rojasLocal = Integer.parseInt(premierCSV.get(13));
		Integer rojasVisitante = Integer.parseInt(premierCSV.get(14));
		Double probabilidad = Double.parseDouble(premierCSV.get(15).replaceAll(",", "."));
		Boolean lluvia = Boolean.valueOf(premierCSV.get(16));
		List<String> colorLocal = Arrays.asList(premierCSV.get(17).split(", "));
	
	return new PremierLeague(temporada, hora, local, visitante, golesLocal, golesVisitante,
			resultado, golesLocalDescanso, golesVisitanteDescanso, resuladoDescanso, arbitro, amarillasLocal,
			amarillasVisitante, rojasLocal, rojasVisitante, probabilidad, lluvia, colorLocal);
	}
	
	/* Método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y 
	devuelve una lista de objetos del tipo.*/
	public static List<PremierLeague> leerDataset(List<List<String>> dataset) {
		List<PremierLeague> partidos = new ArrayList<>();
		for (List<String> partido:dataset) {
			partidos.add(parsearPremierLeague(partido));
		}
		return partidos;
	}

}




















