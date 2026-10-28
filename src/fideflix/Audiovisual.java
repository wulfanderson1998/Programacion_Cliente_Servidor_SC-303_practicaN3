package fideflix;
import java.util.ArrayList;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
//***CAMBIO DE PRÁCTICA PROGRAMADA #2** CLASE ABSTRACTA
public abstract class Audiovisual {
    //Atributos de superclase
    protected String nombre;
    protected int agnioFilmacion;
    protected String director;
    protected String paisOrigen;
    protected String duracion;
    protected String protagonistas;
    protected String actores;
    protected float calificacion;
    //***CAMBIO DE PRÁCTICA PROGRAMADA #2** SE CAMBIÓ EL ORIGINAL POR TIPO STRING
    protected static ArrayList<String> comentarios = new ArrayList<>();
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAgnioFilmacion() {
        return agnioFilmacion;
    }
    public void setAgnioFilmacion(int añoFilmacion) {
        this.agnioFilmacion = añoFilmacion;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getPaisOrigen() {
        return paisOrigen;
    }
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    public String getDuracion() {
        return duracion;
    }
    //Este método se hereda tal cual a Serie y Documental, pero se implementa en otra forma
    //dentro de Película debido a que no tienen temporadas y capítulos.
    public void setDuracion(String temporadas, String capitulos) {
        this.duracion = temporadas+" temporadas y "
            +capitulos+" capitulos";
    }
    public String getProtagonistas() {
        return protagonistas;
    }
    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }
    public String getActores() {
        return actores;
    }
    public void setActores(String actores) {
        this.actores = actores;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    //***CAMBIO DE PRÁCTICA PROGRAMADA #2** AÑADÍ EL MÉTODO (agregarComentario).
    //Ahora, este toma un String y lo agrega a la colección de comentarios.
    public static void agregarComentario(String mensaje){
        comentarios.add(mensaje);
    }
    //Esta función ya no está disponible porque los comentarios son String comunes
    /*
    public void calcularCalificacion(){
        float suma = 0;
        for (int i = 0; i<comentarios.size();i++){
            suma += comentarios.get(i).calificacion;
        }
        this.calificacion = suma/comentarios.size();
    }
    */
}
