package fideflix;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
public class Serie extends Audiovisual implements Comparable<Serie> {
    public Serie(String nombre, int agnioFilmacion, String director, String paisOrigen, String protagonistas, String actores) {
        super.nombre = nombre;
        super.agnioFilmacion = agnioFilmacion;
        super.director = director;
        super.paisOrigen = paisOrigen;
        super.protagonistas = protagonistas;
        super.actores = actores;
    }
    //***CAMBIO DE PRÁCTICA PROGRAMADA #2** IMPLEMENTÉ LA INTERFACE Comparable.
    //Se comparan por año de filmación.
    public int compareTo(Serie otro){
        return Integer.compare(this.agnioFilmacion, otro.agnioFilmacion);
    }
}
