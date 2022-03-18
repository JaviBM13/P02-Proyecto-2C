package fp.premier.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fp.premier.PremierLeague;
import fp.premier.Resultado;

public class PremierLeagueTest {

	public static void main(String[] args) {

		/** ENTREGA 1**/
		System.out.println("- Entrega 1: ");
		List<String> lista = new ArrayList<String>();
		lista.add("rojo");
		lista.add("blanco");
		
		PremierLeague ejemplo1 = new PremierLeague("2021-22", LocalDateTime.of(2021, 9, 11, 15, 00, 00), "Man United", "Newcastle", 4, 1, 
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
		

	}

}
