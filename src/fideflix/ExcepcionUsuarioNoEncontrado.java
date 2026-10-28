package fideflix;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
public class ExcepcionUsuarioNoEncontrado extends Exception {
    public ExcepcionUsuarioNoEncontrado(String usuario) {
        super("El usuario " + usuario + " no fue encontrado.");
    }
}
