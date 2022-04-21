package fp.premier;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.premier.PremierLeague;

public class PremierLeagues {
	
	/**ENTREGA 2**/
	
	/*  propiedad de tipo colecci�n para almacenar los elementos del tipo base: 
	 * elijo Set porque los partidos son �nicos y no se pueden repetir*/
	private Set<PremierLeague> partidos;
	
	/*  Constructor que crea un objeto de tipo contenedor sin ning�n elemento en la colecci�n*/
	public PremierLeagues() {
		partidos = new HashSet<>();
	}
	
	/* Constructor con todas las propiedades b�sicas y una colecci�n de objetos del tipo base, que cree un 
	objeto de tipo contenedor con todos los elementos de la colecci�n.*/
	public PremierLeagues(Stream<PremierLeague> objetos) {
		partidos = objetos.collect(Collectors.toSet());
	}
	
	/* Criterio de igualdad y una representaci�n como cadena*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partidos == null) ? 0 : partidos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremierLeagues other = (PremierLeagues) obj;
		if (partidos == null) {
			if (other.partidos != null)
				return false;
		} else if (!partidos.equals(other.partidos))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PremierLeagues" + partidos;
	}
	
	/*M�todo para obtener el n�mero de elementos*/
	public Integer numeroDePartidos() {
		return partidos.size();
	}

	/* M�todo para a�adir un elemento. */
	public void a�adirPartido(PremierLeague partido) {
		partidos.add(partido);
	}
	
	/* M�todo para a�adir una colecci�n de elementos.
	List<PremierLeague> lista = new ArrayList<>();
	public void a�adirListaPartidos(List<PremierLeague> partido) {
		partidos.add((PremierLeague) lista);
	}*/
	
	/* M�todo para eliminar un elemento.*/
	public void eliminarPartido(PremierLeague partido) {
		partidos.remove(partido);
	}
	
	/*1) A escoger uno de los dos siguientes: existe / para todo.
	 * Obtengo el n�mero de partidos con lluvia*/
	public Integer partidosLluvia() {
		Integer resultado = 0;
		for (PremierLeague p: partidos) {
			if (p.getLluvia().equals(true)) {
				resultado++;
			}
		}
		return resultado;
	}
	
	
	/*2) A escoger uno de los tres siguientes: contador / suma / media.
	 * Elijo el contador y busco cu�ntos partidos se juegan en una determinada fecha y hora*/
	public Integer contador(Instant fecha) {
		Integer cont = 0;
		for (PremierLeague p:partidos) {
			if (p.getHora().equals(fecha)) {
				cont++;
			}
		}
		return cont;
	}
	
	
	/*3) Una selecci�n con filtrado.
	 * Filtro por partidos cuyo local ten�a el rojo entre los colores 
	 * de su equipaci�n*/
	public List<PremierLeague> seleccion() {
		List<PremierLeague> resultado = new ArrayList<>();
		for (PremierLeague p:partidos) {
			if (p.getLocal().equals("Man United")) {
				resultado.add(p);
			}
		}
		return resultado;
	}
	
	
	/*4) Un m�todo de agrupaci�n que devuelva un Map en el que las claves sean una propiedad del tipo base, 
	y los valores una colecci�n (List, Set, SortedSet) de objetos del tipo base. 
	clave: equipo; valor: los goles en cada partido*/
	public Map<String, List<Integer>> golesPorEquipoLocal() {
		Map<String, List<Integer>> resultado = new HashMap<>();
		for (PremierLeague p:partidos) {
			if (resultado.containsKey(p.getLocal())) {
				//a�adir a la lista de los valores los goles
				resultado.get(p.getLocal()).add(p.getGolesLocal());
			}else {
				//crear la lista de valores con los goles del primer partido
				List<Integer> valores = new ArrayList<>();
				valores.add(p.getGolesLocal());
				resultado.put(p.getLocal(), valores);
			}
		}
		return resultado;
	}
	
	
	/*5) Un m�todo de acumulaci�n que devuelva un Map en el que las claves sean una propiedad del tipo 
	base, y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que 
	tienen como valor esa propiedad.
	clave: equipo, valor: los goles totales que ha marcado siendo local*/
	public Map<String, Integer> golesTotalesPorEquipoLocal() {
		Map<String, Integer> resultado = new HashMap<>();
		for (PremierLeague p:partidos) {
			if (resultado.containsKey(p.getLocal())) {
				//si el local ya est� como clave:
				//guardo los goles que ya tengo
				   int goles = resultado.get(p.getLocal()) + p.getGolesLocal();
				//sumo los goles de este partido a los anteriores
				   resultado.put(p.getLocal(), goles);
				}else {
					//si el local no est� como clave, poner el local en la clave y los goles en el valor
				    resultado.put(p.getLocal(), p.getGolesLocal());
				}
		}
		return resultado;
	}
	

}
