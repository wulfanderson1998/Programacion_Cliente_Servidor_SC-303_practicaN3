
package fideflix;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 * Esta clase se encarga de gestionar el registro de usuarios.
 */
public class RegistroDeUsuarios {
    //Método para registrar a un nuevo usuario en el archivo.
    public static void anadirUsuario(Usuario usuario){
        RepositorioArchivo archivoUsuarios = new RepositorioArchivo(
                new File("usuarios.dat"));
        ArrayList<Usuario> usuarios;
        try {
            usuarios = archivoUsuarios.cargar(); //Cargar colección de usuarios.
            usuarios.add(usuario);               //Se almacena el usuario en la colección.
            archivoUsuarios.guardar(usuarios);   //Se guarda en el archivo, según lo especificado en las instrucciones.
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Método para leer colección de usuarios desde usuarios.dat
    public static ArrayList<Usuario> leerUsuario(){
                RepositorioArchivo archivoUsuarios = new RepositorioArchivo(
                new File("usuarios.dat"));
        ArrayList<Usuario> usuarios;
        try {
            usuarios = archivoUsuarios.cargar(); //Cargar colección de usuarios.
            return usuarios;                     //Retornar el ArrayList de usuarios.
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
