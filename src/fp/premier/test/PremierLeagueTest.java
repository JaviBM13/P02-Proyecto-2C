package fp.premier.test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import fp.premier.FactoriaPremierLeagues;
import fp.premier.PremierLeague;
import fp.premier.PremierLeagues;
import fp.premier.Resultado;

public class PremierLeagueTest {

	public static void main(String[] args) {

		/** ENTREGA 1**/
		
		System.out.println("- Entrega 1: ");
		List<String> lista = new ArrayList<String>();
		lista.add("rojo");
		lista.add("blanco");
		
		PremierLeague ejemplo1 = new PremierLeague("2021-22", Instant.now(), "Man United", "Newcastle", 4, 1, 
				Resultado.H, 1, 0, Resultado.H, "A Taylor", 1, 0, 0, 0, 60.0, false, lista);  
		
		//Compruebo que sale todo con el formato cadena
		System.out.println(ejemplo1.toString());
		
		//Uso un get
		System.out.println(ejemplo1.getLocal());
		
		//Modifico un valor con un set
		ejemplo1.setGolesLocal(8);
		
		//Compruebo que se ha modificado 
		System.out.println(ejemplo1.getGolesLocal());
		System.out.println(ejemplo1.toString());
		
		System.out.println("*************************");
		
		/**ENTREGA 2**/
		 
		System.out.println("- Entrega 2: ");
		
		List<List<String>> csv = FactoriaPremierLeagues.readCSV("data/results.csv");
		List<PremierLeague> partidos = FactoriaPremierLeagues.leerDataset(csv);
		
		/*Genero un objeto tipo PremierLeague para probar los métodos añadir, eliminar...*/
		PremierLeagues ejemplo2 = new PremierLeagues();
		
		/*Imprimo para verificar que no hay elementos*/
		System.out.println(ejemplo2.toString());
		
		/*Pruebo añadirPartido*/
		ejemplo2.añadirPartido(ejemplo1);
		System.out.println("Método añadirPartido: " + ejemplo2);
		
		/*Pruebo numeroDePartidos*/
		System.out.println("Método numeroDePartidos: " + ejemplo2.numeroDePartidos());
		
		/*Pruebo eliminarPartido*/
		ejemplo2.eliminarPartido(ejemplo1);
		System.out.println("Método eliminarPartido: " + ejemplo2);
		
		/*PRUEBA DE LOS PRIMEROS TRATAMIENTOS SECUENCIALES*/
		PremierLeagues res = new PremierLeagues(partidos.stream());
		System.out.println();
		System.out.println("PRIMEROS TRATAMIENTOS SECUENCIALES: ");
		System.out.println("1) Número de partidos con lluvia: " + res.partidosLluvia());
		System.out.println("2) Número el 2020-10-04T12:00:00Z: " + res.contador(Instant.parse("2020-10-04T12:00:00Z")));
		System.out.println("3) Partidos cuyo local era el Manchester United: " + res.seleccion());
		System.out.println("4) Goles que cada equipo ha marcado en cada partido de local: " + res.golesPorEquipoLocal());
		System.out.println("5) Número total de goles que cada equipo ha marcado siendo local: " + res.golesTotalesPorEquipoLocal());
		System.out.println("*************************");
	}
}
