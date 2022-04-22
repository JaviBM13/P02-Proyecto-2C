"# fp-proyecto-java-is2-2-JaviBM13" 
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor: Javier Blasco Moreno

uvus:javblamor1

El dataset trata sobre los partidos de la Premier League de la temporada pasada y la actual. Este incluye varias columnas
en las que se incluye la fecha del partido, el equipo local y visitante, los goles que marcaron cada uno, cuál fue
el resultado, la probabilidad que tenía de ganar el equipo local...

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.premierleague**: Paquete que contiene los tipos del proyecto.
  * **fp.premierleague.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **results.csv**: Añade una descripción genérica del dataset.
* **/doc**: Contiene el enunciado del proyecto
    
## Estructura del *dataset*

La URL del dataset original es: http://kaggle.com/irkaal/english-premier-league-results

El dataset está compuesto por 16 columnas, con la siguiente descripción:

* **Temporada**: de tipo String, representa la temporada a la que pertenece el partido.
* **Hora**: de tipo LocalDateTime, representa la fecha y hora del partido.
* **Local**: de tipo String, representa el equipo local.
* **Visitante**: de tipo String, representa el equipo visitante.
* **GolesLocal**: de tipo Integer, representa los goles del equipo local.
* **GolesVisitante**: de tipo Integer, representa los goles del equipo visitante.
* **Resultado**: de tipo Enumerate, representa si el ganador fue el local (H), visitante (A) o empate (D).
* **GolesLocalDescanso**: de tipo Integer, representa los goles del equipo local al descanso.
* **GolesVisitanteDescanso**: de tipo Integer, representa los goles del equipo visitante al descanso.
* **ResultadoDescanso**: de tipo Enumerate, representa si el ganador al descanso era el local (H), visitante (A) o empate (D).
* **Arbitro**: de tipo String, representa el árbitro del partido.
* **AmarillasLocal**: de tipo Integer, representa las amarillas que tuvieron los locales.
* **AmarillasVisitante**: de tipo Integer, representa las amarillas que tuvieron los visitantes.
* **RojasLocal**: de tipo Integer, representa las rojas que tuvieron los locales.
* **RojasVisitante**: de tipo Integer, representa las rojas que tuvieron los visitantes.
* **Probabilidad**: de tipo Double, representa la probabilidad que tenía el local de ganar el partido.
* **Lluvia**: de tipo Boolean, representa si llovió durante el partido.
* **ColorLocal**: de tipo List<String>, representa los colores de la equipación del equipo local.

## Tipos implementados
Uso el tipo Resultado, que es un enum cuyos valores son H, A , D. 
Un tipo List<String>, estas listas tienen dos o tres elementos.

### Tipo Base
Añado las propiedades, constructores y métedos pedidos sobre los partidos de la Premier League del dataset

**Propiedades**:
String temporada, consultable y modificable.
 LocalDateTime hora, consultable y modificable.
 String local, consultable y modificable.
 String visitante, consultable y modificable.
 Integer golesLocal, consultable y modificable.
 Integer golesVisitante, consultable y modificable.
 Resultado resultado, consultable y modificable.
 Integer golesLocalDescanso, consultable y modificable.
 Integer golesVisitanteDescanso, consultable y modificable.
 Resultado resuladoDescanso, consultable y modificable.
 String arbitro, consultable y modificable.
 Integer amarillasLocal, consultable y modificable.
 Integer amarillasVisitante, consultable y modificable.
 Integer rojasLocal, consultable y modificable.
 Integer rojasVisitante, consultable y modificable.
 Double probabilidad, consultable y modificable.
 Boolean lluvia, consultable y modificable.
 List<String> colorLocal, consultable y modificable.
 
 La propiedad derivada que he añadido es: public Integer getNumeroDias() con la que saco el número de días que han pasado desde un partido.
    
**Constructores**: 

- C1: añade todas las propiedades básicas las restricciones
- C2: añade las propiedades: local, visitante, golesLocal, golesVisitante. Estas tienen un valor y el resto son nulas.

**Restricciones**:
 
- R1: Comprueba que el equipo local es diferente al visitante.
- R2: Comprueba que un equipo no puede ganar sin haber marcado ningún gol.

**Criterio de ordenación**: Ordenado por orden cronológico. Si hay dos con fechas y horas iguales, se ordenará por
 orden alfabético de los equipos locales.
	
Hasta aquí lo realizado en la primera entrega.

*Entrega 2*:
	
**FactoriaPremierLeagues**
He añadido la clase FactoriaPremierLeagues donde realizo el parseo de todos los datos y leo el CSV.
* **read CSV**: Aquí encontramos el método con el cual leo el fichero.
* **parsearPremierLeague**: este método recibe como parámetro una cadena con el formato de las líneas del fichero CSV, y 
	devuelve un objeto del tipo a partir de esa cadena.
* **leerDataset**:  Método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y 
	devuelve una lista de objetos del tipo.
	
**PremierLeagues**
	
* **partidos**: propiedad de tipo colección para almacenar los elementos del tipo base
* **numeroDePartidos()**: Método para obtener el número de elementos
* **añadirPartido(PremierLeague partido)**: Método para añadir un elemento.
* **añadirListaPartidos(Set<PremierLeague> partido)**: Método para añadir una colección de elementos.
* **eliminarPartido(PremierLeague partido)**: Método para eliminar un elemento.

**Tratamientos secuenciales con bucle**
	
* **1) partidosLluvia()**:  Obtengo el número de partidos con lluvia
* **2) contador(Instant fecha)**: Hago un contador con el que busco cuántos partidos se juegan en una determinada fecha y hora
* **3) seleccion()**: Una selección con filtrado donde filtro por partidos cuyo local era el Manchester United*/
* **4) golesPorEquipoLocal()**: Un método de agrupación que devuelva un Map en el que las claves sean el equipo y los valores 
	una lista de los goles en cada partido de local. 
	clave: equipo; valor: los goles en cada partido
* **5) golesTotalesPorEquipoLocal()**: Un método de acumulación que devuelva un Map en el que las claves sean los equipos
	y los valores la suma de los goles que han marcado como local
	clave: equipo, valor: los goles totales que ha marcado siendo local
	
**PremierLeagueTest**
 He comprobado que todos los ejercicios eran correctos.
