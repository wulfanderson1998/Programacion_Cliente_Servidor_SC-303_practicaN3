package fideflix;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
public class Documental extends Audiovisual implements Comparable<Documental>{
    public Documental(String nombre, int agnioFilmacion, String director, String paisOrigen, String actores) {
        super.nombre = nombre;
        super.agnioFilmacion = agnioFilmacion;
        super.director = director;
        super.paisOrigen = paisOrigen;
        super.actores = actores;
    }
    //***CAMBIO DE PRÁCTICA PROGRAMADA #2** IMPLEMENTÉ LA INTERFACE Comparable.
    //Se comparan por nombre alfabéticamente .
        public int compareTo(Documental otro){
        return this.nombre.compareTo(otro.nombre);
    }
}
