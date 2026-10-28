package fideflix;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 * ---
 * ---
 * NOTAS NUEVAS, PRÁCTICA #3
 * Se añadió un comentario con la etiqueta ***CAMBIOS DE PRÁCTICA PROGRAMADA #3** para
 * identificar las secciones donde se implementaron cambios.
 * Se actualizaron las clases Main y VentanaMenuPrincipal. Ahora Menu se llama VentanaMenuPrincipal. 
 * Se añadieron las clases:
 * VentanaCrearUsuario: Se remplazó el formulario JTable original con un menú más personalizado y 
 * profesional (utilizando JFrame forms).
 * RepositorioArchivo: Se creó una clase repositorio para cargar y guardar archivos según lo visto en 
 * la sesión sincrónica de la semana #6.
 * RegistroDeUsuarios: Esta clase se encarga de gestionar el registro de usuarios. Es decir,
 * usa los métodos del repositorio para abrir el archivo, editarlo y luego guardarlo. Los pasos se ejecutan
 * en ese orden siguiendo las instrucciones de la práctica #3.
 * Sobre VentanaInicioSesion: no se creó un archivo aparte. La ventana de inicio de sesión
 * se implementa dentro de VentanaMenuPrincipal. 
 * ---
 * NOTAS PRÁCTICA #2
 * Se añadió un comentario con la etiqueta ***CAMBIOS DE PRÁCTICA PROGRAMADA #2** para
 * identificar las secciones donde se implementaron cambios.
 * ---
 * NOTAS DE PRÁCTICA #1
 * SE UTILIZARÁN LAS SIGUIENTES CLASES
 * ---
 * Main: Clase de arranque (transitoria).
 * ---
 * VentanaMenuPrincipal: Lógica principal del menú. 
 * ---
 * Audiovisual: Superclase de la que heredan Pelicula, Serie y Documental.
 * Audiovisual define los atributos más importantes que son comunes a las
 * subclases. Elegí usar una clase regular porque el método setDuracion()
 * se comporta igual en Serie y Documental y solo requiere una implementación
 * adicional en la clase Pelicula.
 * ---
 * Comentario: Los objetos de tipo Comentario almacenan la calificación y
 * el comentario de un usuario. Además, sirven para dar trazabilidad de quién
 * emitió una calificación.
 */
public class Main {
    public static void main(String[] args) {
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** Añadir colección de usuarios.
        //Se ejecutan los cambios en el main según instrucciones.
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** Agregar 10 objetos de clase Usuario.
        //Todos diferentes, según instrucciones. 
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #3** Se comentó toda esta sección de la PRÁCTICA PROGRAMADA #2 
        //para evitar el ruido visual y para implementar lo requerido usando ventanas.
        //#############################################################################################
                /*
                ArrayList<Usuario> usuarios = new ArrayList<>();
                //Todos diferentes, según instrucciones.
                Usuario carlos = new Usuario("carlosCR", "1234");
                Usuario maria = new Usuario("mariaSol",  "1234");
                Usuario jose = new Usuario("joseTico", "1234");
                Usuario ana = new Usuario("anaLuna", "1234");
                Usuario luis = new Usuario("luisPro", "1234");
                Usuario sofia = new Usuario("sofiaCR", "1234");
                Usuario daniel = new Usuario("danielGT", "1234");
                Usuario laura = new Usuario("lauraSky", "1234");
                Usuario andres = new Usuario("andresDev", "1234");
                Usuario paula = new Usuario("paulaStar", "1234");
                //Se añaden los usuarios
                usuarios.add(carlos);
                usuarios.add(maria);
                usuarios.add(jose);
                usuarios.add(ana);
                usuarios.add(luis);
                usuarios.add(sofia);
                usuarios.add(daniel);
                usuarios.add(laura);
                usuarios.add(andres);
                usuarios.add(paula);
                //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** Eliminar un usuario y manejar excepción
                //Usuario real
                try {
                    eliminarUsuario("carlosCR", usuarios);
                } catch (ExcepcionUsuarioNoEncontrado e){
                    System.out.println(e.getMessage()); //Se manejó en forma similar a la guía interactiva de esta semana.
                }                                      
                //Usuario no existente
                try {
                    eliminarUsuario("raquel22", usuarios);
                } catch (ExcepcionUsuarioNoEncontrado g){
                    System.out.println(g.getMessage()); //Se manejó en forma similar a la guía interactiva.
                }
                //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** Se utiliza método sort() para ordenar Usuarios.
                //Se implementó el método comparable por orden alfabético, sin tomar en cuenta
                //mayúsculas y minúsculas.
                usuarios.sort(null); //sort sin usar comparator, solo Comparable
                */
        //#############################################################################################
        //CÓDIGO DE PRÁCTICA PROGRAMADA #1.
        VentanaMenuPrincipal menu = new VentanaMenuPrincipal();
        menu.generarPeliculasEjemplo();
        menu.generarSeriesEjemplo();
        menu.generarDocumentalesEjemplo();
        menu.pantallaInicioSesion();
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** Destrucción de los objetos al terminar.
        menu = null;
        
    }
    //***CAMBIOS DE PRÁCTICA PROGRAMADA #2** 
    //Método para remover usuarios mediante su nombre de usuario.
    public static void eliminarUsuario(String usuario, ArrayList<Usuario> usuarios) throws ExcepcionUsuarioNoEncontrado {
        for (int x = 0; x < usuarios.size(); x++){
            if (usuarios.get(x).getUsuario().equals(usuario)){
                usuarios.remove(x); //Método .remove()
                System.out.println(
                        "El usuario "+usuario+" fue eliminado satisfactoriamente");
                return; 
            }
        }
        throw new ExcepcionUsuarioNoEncontrado(usuario);
    }
}
