package fideflix;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
public class Pelicula extends Audiovisual implements Comparable<Pelicula> {
    public Pelicula(String nombre, int agnioFilmacion, String director, String paisOrigen, String protagonistas, String actores) {
        super.nombre = nombre;
        super.agnioFilmacion = agnioFilmacion;
        super.director = director;
        super.paisOrigen = paisOrigen;
        super.protagonistas = protagonistas;
        super.actores = actores;
    }
    //Este método se hereda tal cual a Serie y Documental, pero se implementa en otra forma
    //dentro de Película debido a que no tiene temporadas y capítulos.
    @Override
    public void setDuracion(String horas, String minutos) {
        super.duracion = horas+" horas y "
            +minutos+" minutos";
    }
    //***CAMBIO DE PRÁCTICA PROGRAMADA #2** IMPLEMENTÉ LA INTERFACE Comparable.
    //Se comparan por año de filmación.
    public int compareTo(Pelicula otro){
        return Integer.compare(this.agnioFilmacion, otro.agnioFilmacion);
    }
}
