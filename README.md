# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<XX\>/\<YY\>)
Autor/a: Javier Blasco Moreno   uvus:javblamor1

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

## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Base
Descripción breve del tipo base.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
