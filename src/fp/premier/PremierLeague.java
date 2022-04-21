package fp.premier;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import fp.utiles.Checkers;


public class PremierLeague implements Comparable<PremierLeague> {
	
	/** ENTREGA 1 **/
	
	/* Hay mínimo un integer, double, String, boolean, fecha y hora, enumerado 
	 * y un tipo auxiliar o lista/conjunto, en este caso una lista*/
	private String temporada;
	private Instant hora;
	private String local;
	private String visitante;
	private Integer golesLocal;
	private Integer golesVisitante;
	private Resultado resultado;
	private Integer golesLocalDescanso;
	private Integer golesVisitanteDescanso;
	private Resultado resuladoDescanso;
	private String arbitro;
	private Integer amarillasLocal;
	private Integer amarillasVisitante;
	private Integer rojasLocal;
	private Integer rojasVisitante;
	private Double probabilidad;
	private Boolean lluvia;
	private List<String> colorLocal;
	
	/*Hago los dos constructores, uno de ellos con restricciones*/
	
	//CONSTRUCTOR 1
	public PremierLeague(String temporada, Instant hora, String local, String visitante, Integer golesLocal, Integer golesVisitante,
		Resultado resultado, Integer golesLocalDescanso, Integer golesVisitanteDescanso, Resultado resuladoDescanso, String arbitro, Integer amarillasLocal,
		Integer amarillasVisitante, Integer rojasLocal, Integer rojasVisitante, Double probabilidad, Boolean lluvia, List<String> colorLocal) {
		
		//Hago dos restricciones:
		Checkers.check("El equipo local no puede ser el mismo que el visitante", !local.equals(visitante));
		
		/*if (local.equals(visitante)) {
			throw new IllegalArgumentException("El equipo local no puede ser el mismo que el visitante");
		}*/
		
		if (golesLocal == 0 && resultado == Resultado.H || golesVisitante == 0 && resultado == Resultado.A) {
			throw new IllegalArgumentException("Un equipo no puede ganar sin haber marcado gol");
		}
		
		this.temporada = temporada;
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.resultado = resultado;
		this.golesLocalDescanso = golesLocalDescanso;
		this.golesVisitanteDescanso = golesVisitanteDescanso;
		this.resuladoDescanso = resuladoDescanso;
		this.arbitro = arbitro;
		this.amarillasLocal = amarillasLocal;
		this.amarillasVisitante = amarillasVisitante;
		this.rojasLocal = rojasLocal;
		this.rojasVisitante = rojasVisitante;
		this.probabilidad = probabilidad;
		this.lluvia = lluvia;
		this.colorLocal = colorLocal;
		
	}
	
	//CONSTRUCTOR 2
	public PremierLeague(String local, String visitante, Integer golesLocal, Integer golesVisitante) {
		
		this(null, null, local, visitante, golesLocal, 0, null, null, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	/* Propiedad derivada: Saco el número de días que han pasado desde un partido */
	
    public Integer getNumeroDias() {
    	LocalDate hoy = LocalDate.now(); // creo una variable con el día de hoy
    	Long dias = ChronoUnit.DAYS.between((Temporal) this.hora, hoy); //calculo los días entre la fecha del partido y la variable 'hoy'
    	return dias.intValue(); //el "intValue" es para cambiar "dias" de Long a Integer
    }

    //Representación como cadena: el formato sería el nombre de la propiedad igual a el valor de esa propiedad, separando las propiedades por comas.
	@Override
	public String toString() {
		return "temporada=" + temporada + ", fecha=" + hora + ", local=" + local + ", visitante="
				+ visitante + ", golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + ", resultado="
				+ resultado + ", golesLocalDescanso=" + golesLocalDescanso + ", golesVisitanteDescanso="
				+ golesVisitanteDescanso + ", resuladoDescanso=" + resuladoDescanso + ", arbitro=" + arbitro
				+ ", amarillasLocal=" + amarillasLocal + ", amarillasVisitante=" + amarillasVisitante + ", rojasLocal="
				+ rojasLocal + ", rojasVisitante=" + rojasVisitante + ", probabilidad=" + probabilidad
				+ "%, Lluvia=" + lluvia + ", Color= " + colorLocal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amarillasLocal == null) ? 0 : amarillasLocal.hashCode());
		result = prime * result + ((amarillasVisitante == null) ? 0 : amarillasVisitante.hashCode());
		result = prime * result + ((arbitro == null) ? 0 : arbitro.hashCode());
		result = prime * result + ((colorLocal == null) ? 0 : colorLocal.hashCode());
		result = prime * result + ((golesLocal == null) ? 0 : golesLocal.hashCode());
		result = prime * result + ((golesLocalDescanso == null) ? 0 : golesLocalDescanso.hashCode());
		result = prime * result + ((golesVisitante == null) ? 0 : golesVisitante.hashCode());
		result = prime * result + ((golesVisitanteDescanso == null) ? 0 : golesVisitanteDescanso.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((lluvia == null) ? 0 : lluvia.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((probabilidad == null) ? 0 : probabilidad.hashCode());
		result = prime * result + ((resuladoDescanso == null) ? 0 : resuladoDescanso.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result + ((rojasLocal == null) ? 0 : rojasLocal.hashCode());
		result = prime * result + ((rojasVisitante == null) ? 0 : rojasVisitante.hashCode());
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
		result = prime * result + ((visitante == null) ? 0 : visitante.hashCode());
		return result;
	}
	
	//Esto es el criterio de igualdad, hecho con equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremierLeague other = (PremierLeague) obj;
		if (amarillasLocal == null) {
			if (other.amarillasLocal != null)
				return false;
		} else if (!amarillasLocal.equals(other.amarillasLocal))
			return false;
		if (amarillasVisitante == null) {
			if (other.amarillasVisitante != null)
				return false;
		} else if (!amarillasVisitante.equals(other.amarillasVisitante))
			return false;
		if (arbitro == null) {
			if (other.arbitro != null)
				return false;
		} else if (!arbitro.equals(other.arbitro))
			return false;
		if (colorLocal == null) {
			if (other.colorLocal != null)
				return false;
		} else if (!colorLocal.equals(other.colorLocal))
			return false;
		if (golesLocal == null) {
			if (other.golesLocal != null)
				return false;
		} else if (!golesLocal.equals(other.golesLocal))
			return false;
		if (golesLocalDescanso == null) {
			if (other.golesLocalDescanso != null)
				return false;
		} else if (!golesLocalDescanso.equals(other.golesLocalDescanso))
			return false;
		if (golesVisitante == null) {
			if (other.golesVisitante != null)
				return false;
		} else if (!golesVisitante.equals(other.golesVisitante))
			return false;
		if (golesVisitanteDescanso == null) {
			if (other.golesVisitanteDescanso != null)
				return false;
		} else if (!golesVisitanteDescanso.equals(other.golesVisitanteDescanso))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (lluvia == null) {
			if (other.lluvia != null)
				return false;
		} else if (!lluvia.equals(other.lluvia))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (probabilidad == null) {
			if (other.probabilidad != null)
				return false;
		} else if (!probabilidad.equals(other.probabilidad))
			return false;
		if (resuladoDescanso != other.resuladoDescanso)
			return false;
		if (resultado != other.resultado)
			return false;
		if (rojasLocal == null) {
			if (other.rojasLocal != null)
				return false;
		} else if (!rojasLocal.equals(other.rojasLocal))
			return false;
		if (rojasVisitante == null) {
			if (other.rojasVisitante != null)
				return false;
		} else if (!rojasVisitante.equals(other.rojasVisitante))
			return false;
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		if (visitante == null) {
			if (other.visitante != null)
				return false;
		} else if (!visitante.equals(other.visitante))
			return false;
		return true;
	}

	/*Criterio de Orden Natural usando compareTo para que lo ordene cronológicamente. 
	 * Si los partidos fueron a la vez, los ordena alfabéticamente*/
	@Override
	public int compareTo(PremierLeague o) {
		int res = this.getHora().compareTo(o.getHora());
		if (res == 0) {
			res = this.getLocal().compareTo(o.getLocal());
		}
		return res;
	}
	
	//Getters y setters de todas las propiedades básicas, ya que son consultables y modificables
	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public Instant getHora() {
		return hora;
	}

	public void setHora(Instant hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Integer getGolesLocalDescanso() {
		return golesLocalDescanso;
	}

	public void setGolesLocalDescanso(Integer golesLocalDescanso) {
		this.golesLocalDescanso = golesLocalDescanso;
	}

	public Integer getGolesVisitanteDescanso() {
		return golesVisitanteDescanso;
	}

	public void setGolesVisitanteDescanso(Integer golesVisitanteDescanso) {
		this.golesVisitanteDescanso = golesVisitanteDescanso;
	}

	public Resultado getResuladoDescanso() {
		return resuladoDescanso;
	}

	public void setResuladoDescanso(Resultado resuladoDescanso) {
		this.resuladoDescanso = resuladoDescanso;
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}

	public Integer getAmarillasLocal() {
		return amarillasLocal;
	}

	public void setAmarillasLocal(Integer amarillasLocal) {
		this.amarillasLocal = amarillasLocal;
	}

	public Integer getAmarillasVisitante() {
		return amarillasVisitante;
	}

	public void setAmarillasVisitante(Integer amarillasVisitante) {
		this.amarillasVisitante = amarillasVisitante;
	}

	public Integer getRojasLocal() {
		return rojasLocal;
	}

	public void setRojasLocal(Integer rojasLocal) {
		this.rojasLocal = rojasLocal;
	}

	public Integer getRojasVisitante() {
		return rojasVisitante;
	}

	public void setRojasVisitante(Integer rojasVisitante) {
		this.rojasVisitante = rojasVisitante;
	}

	public Double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Double probabilidad) {
		this.probabilidad = probabilidad;
	}

	public Boolean getLluvia() {
		return lluvia;
	}

	public void setLluvia(Boolean lluvia) {
		this.lluvia = lluvia;
	}
	
	public List<String> getColorLocal() {
		return colorLocal;
	}

	public void setColorLocal(List<String> colorLocal) {
		this.colorLocal = colorLocal;
	}
}
