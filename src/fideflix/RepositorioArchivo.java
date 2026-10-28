package fideflix;
//Librerías
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */

// Esta clase se encarga de la gestión de archivos y la serialización de la información.
public class RepositorioArchivo {
    //Atributos
    private final File archivo; // Directorio del archivo
    //Constructor
    public RepositorioArchivo(File archivo) {
        this.archivo = archivo;
    }
    /*Este método lee, deserializa y carga un ArrayList<Usuario> desde el archivo en el directorio
     *previamente especificado. Además, lanza varias excepciones en ciertos casos de error. 
     */
    public ArrayList<Usuario> cargar() throws IOException, ClassNotFoundException {
        //Si el archivo no existe pudo haberse borrado o movido. También puede que todavía no exista. 
        if (!archivo.exists()){ //Verificar existencia de archivo:
            return new ArrayList<>(); //Si no existe, se crea un nuevo ArrayList.
        }
    // Se crea un objeto de tipo FileInputStream para leer un flujo de bytes
        try (FileInputStream lectorDatos = new FileInputStream(archivo);
        ObjectInputStream deserializadorDatos = new ObjectInputStream(lectorDatos)){ // Se crea un objeto ObjectInputStream para deserializar la información. 
            Object contenido = deserializadorDatos.readObject(); //Reconstruir el objeto y apuntar una variable hacia ese objeto.
            if (!(contenido instanceof ArrayList<?>)){ //Verificar la clase del objeto
                throw new IOException("Imposible acceder a la lista de usuarios, el archivo proporcionado "
                        + "no contiene la información requerida");
            }
            //Se crea una referencia hacia el ArrayList con comodín (tipo desconocido). 
            ArrayList<?> listaDesconocida = (ArrayList<?>) contenido; 
            //leer objetos uno cada vez:
            ArrayList<Usuario> usuarios = new ArrayList<>(); //Nueva lista para guardar usuarios.
            for (Object objeto: listaDesconocida){ //Guardar todos los objetos de tipo usuario.
                if (objeto instanceof Usuario){
                    usuarios.add((Usuario)objeto);
                } else {
                    throw new IOException("Se encontró un registro que no pertenece a un Usuario");
                }
            } 
            //Entregar el objeto usuarios de tipo ArrayList<Usuario> al código cliente.
            return usuarios;
        // el try con recursos cierra los flujos de datos. 
        } 
    }
    public void guardar(ArrayList<Usuario> usuarios) throws IOException {
        //Apuntar una variable al directorio padre del archivo. 
        File carpeta = archivo.getParentFile();
        //Verificar si el directorio padre existe
        if ((carpeta != null)&&(!carpeta.exists())&&(!carpeta.mkdirs())){ //Verificar si existe e intentar crearlo.
            throw new IOException("El directorio padre para el archivo "+ archivo.getName() +" no puede ser" //Mostrar un mensaje si el directorio no puede ser creado.
                    + " creado");
        } 
        /*Crear un objeto de tipo FileOutputStream para abrir el archivo original.
         *De no existir el archivo, se crea un nuevo archivo en ese directorio. 
         */
        try (FileOutputStream escritorDatos = new FileOutputStream(archivo);    //try con recursos
            ObjectOutputStream serializadorDatos = new ObjectOutputStream(escritorDatos)){ //Crear objeto de tipo ObjectOutputStream para serializar los datos.
                serializadorDatos.writeObject(usuarios); //Se serializa y escribe la lista de usuarios. El archivo ya se vació al crear el FileOutputStream.
        } //el try con recursos cierra los flujos de datos.
    }    
}
