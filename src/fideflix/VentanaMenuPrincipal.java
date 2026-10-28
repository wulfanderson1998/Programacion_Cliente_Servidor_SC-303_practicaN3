package fideflix;
//Librerías
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente  SC-303
 */
public class VentanaMenuPrincipal {
    //Utilizo ArrayList porque no hay ninguna restricción declarada en el curso o en la rúbrica.
    //Administraré los usuarios que se pueden registrar en el objeto menú.
    //***CAMBIOS DE PRÁCTICA PROGRAMADA #3**
    //Ahora la colección de usuarios se lee directamente desde el archivo de usuarios.dat.
    private ArrayList<Pelicula> peliculas = new ArrayList<>();
    private ArrayList<Serie> series = new ArrayList<>();
    private ArrayList<Documental> documentales = new ArrayList<>();
    private Usuario usuarioActual;
    //#############################################################################
    //Información de películas. OBJETOS PELÍCULA
    //#############################################################################
    public void generarPeliculasEjemplo(){
        Pelicula pelicula1 = new Pelicula(
        "La Odisea",
        2025,
        "Christopher Nolan",
        "Estados Unidos y Reino Unido",
        "Matt Damon, Anne Hathaway y Tom Holland",
        "Robert Pattinson, Lupita Nyong'o, Zendaya, Charlize Theron, "
        + "Jon Bernthal, Benny Safdie, John Leguizamo, Himesh Patel, "
        + "Mia Goth, Elliot Page y Samantha Morton"
    );
    pelicula1.setDuracion("2", "52");
    pelicula1.setCalificacion(0);
    peliculas.add(pelicula1);
    Pelicula pelicula2 = new Pelicula(
        "Spider-Man: Un Nuevo Día",
        2025,
        "Destin Daniel Cretton",
        "Estados Unidos",
        "Tom Holland, Zendaya y Sadie Sink",
        "Jacob Batalon, Jon Bernthal, Mark Ruffalo, Tramell Tillman, "
        + "Michael Mando y Liza Colón-Zayas"
    );
    pelicula2.setDuracion("2", "25");
    peliculas.add(pelicula2);
    Pelicula pelicula3 = new Pelicula(
        "El Padrino",
        1971,
        "Francis Ford Coppola",
        "Estados Unidos",
        "Marlon Brando y Al Pacino",
        "James Caan, Robert Duvall, Diane Keaton, Talia Shire, "
        + "John Cazale, Richard S. Castellano, Sterling Hayden y Abe Vigoda"
    );
    pelicula3.setDuracion("2", "55");
    peliculas.add(pelicula3);
    }
    //#############################################################################
    //Información de series. OBJETOS SERIE
    //#############################################################################
    public void generarSeriesEjemplo() {
        Serie serie1 = new Serie(
            "Stranger Things",
            2016,
            "Varios directores; creada por los hermanos Duffer",
            "Estados Unidos",
            "Millie Bobby Brown, Finn Wolfhard, Winona Ryder y David Harbour",
            "Gaten Matarazzo, Caleb McLaughlin, Noah Schnapp, Sadie Sink, "
            + "Natalia Dyer, Charlie Heaton, Joe Keery y Maya Hawke"
        );
        serie1.setDuracion("5", "42");
        series.add(serie1);
        Serie serie2 = new Serie(
            "The Witcher",
            2019,
            "Varios directores; creada por Lauren Schmidt Hissrich",
            "Estados Unidos",
            "Henry Cavill, Liam Hemsworth, Anya Chalotra y Freya Allan",
            "Joey Batey, MyAnna Buring, Eamon Farren, Mimî M. Khayisa, "
            + "Anna Shaffer, Royce Pierreson y Laurence Fishburne"
        );
        serie2.setDuracion("4", "32");
        series.add(serie2);
        Serie serie3 = new Serie(
            "Peaky Blinders",
            2013,
            "Varios directores; creada por Steven Knight",
            "Reino Unido",
            "Cillian Murphy, Paul Anderson, Helen McCrory y Sophie Rundle",
            "Joe Cole, Finn Cole, Natasha O'Keeffe, Sam Neill, Tom Hardy, "
            + "Anya Taylor-Joy, Sam Claflin y Adrien Brody"
        );
        serie3.setDuracion("6", "36");
        series.add(serie3);
    }
    //#############################################################################
    //Información de documentales. OBJETOS DOCUMENTAL
    //#############################################################################
    public void generarDocumentalesEjemplo() {
        Documental documental1 = new Documental(
            "Los Dinosaurios",
            2026,
            "Nick Shoolingin-Jordan",
            "Estados Unidos",
            "Morgan Freeman (narrador)"
        );
        documental1.setDuracion("1", "4");
        documentales.add(documental1);
        Documental documental2 = new Documental(
            "El Último Baile",
            2020,
            "Jason Hehir",
            "Estados Unidos",
            "Scottie Pippen, Dennis Rodman, Phil Jackson, Steve Kerr, "
            + "Magic Johnson, Larry Bird y David Aldridge"
        );
        documental2.setDuracion("1", "10");
        documentales.add(documental2);
        Documental documental3 = new Documental(
                "Nuestro Planeta",
                2019,
                "Varios directores; producido por Alastair Fothergill y Keith Scholey",
                "Reino Unido",
                "David Attenborough, Salma Hayek y Penélope Cruz (narradores)"
        );
        documental3.setDuracion("2", "12");
        documentales.add(documental3);
    }
    //#############################################################################
    //Métodos del menú
    //#############################################################################
    public void pantallaInicioSesion(){
        //Configuraciones de los JButton
        JButton btnIniciarSesion = new JButton("Iniciar sesión");               //Creé mis propios botones para poder deshabilitarlos
        JButton btnRegistrarse = new JButton("Crear Usuario");
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #3**
        //Ahora la colección de usuarios se lee directamente desde el archivo "usuarios.dat".
        //Para ello, se utilizan los métodos de la clase RegistroDeUsuarios.
        ArrayList<Usuario> usuarios = RegistroDeUsuarios.leerUsuario();
        if (usuarios == null){
            return;
        }
        if (usuarios.isEmpty()){                                                //Iniciar Sesión (no disponible si no hay usuarios registrados)
            btnIniciarSesion.setEnabled(false);
        }
        //Acciones de los JButton
        ejecutarAccionBoton(btnRegistrarse, this::registrarse);                 
        ejecutarAccionBoton(btnIniciarSesion, this::menuIniciarSesion);
        //Menú inicio de sesión
        JOptionPane.showMessageDialog(null, new Object[]{                       //Menú de inicio de sesión
            "Seleccione una opción",
            btnIniciarSesion,
            btnRegistrarse
            },
            "Menú de inicio de sesión",
            JOptionPane.PLAIN_MESSAGE
        );
    }
    public void registrarse(){
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #3**
        //Se remplaza el menú de registro con la nueva versión de la clase: (VentanaCrearUsuario)
        VentanaCrearUsuario menuRegistrarUsuario = new VentanaCrearUsuario(this);
        menuRegistrarUsuario.setVisible(true);
    }    
    public void menuIniciarSesion() {
        //***CAMBIOS DE PRÁCTICA PROGRAMADA #3**
        //Ahora la colección de usuarios se lee directamente desde el archivo "usuarios.dat".
        //Para ello, se utilizan los métodos de la clase RegistroDeUsuarios.
        ArrayList<Usuario> usuarios = RegistroDeUsuarios.leerUsuario();
        if (usuarios == null){
            return;
        }
        String usuario = JOptionPane.showInputDialog(
            null,
            "Ingrese su nombre de usuario:"
        );
        String contrasena = JOptionPane.showInputDialog(
            null,
            "Ingrese su contraseña:"
        );
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).autenticar(usuario, contrasena)) {
                usuarioActual = usuarios.get(i);
                usuarioActual.iniciarSesion(usuarioActual);
                menuPrincipal();
                return;
            }
        }
        // Solo llega aquí si ningún usuario coincidió
        JOptionPane.showMessageDialog(
            null,
            "Acceso denegado. Usuario o contraseña incorrectos."
        );
        pantallaInicioSesion();
    }
    public void menuPrincipal(){
        //Configuraciones de los JButton
        JButton btnPeliculas = new JButton("Películas");
        JButton btnSeries = new JButton("Series");
        JButton btnDocumentales = new JButton("Documentales");
        //Acciones de los JButton
        ejecutarAccionBoton(btnPeliculas, this::menuPeliculas);
        ejecutarAccionBoton(btnSeries, this::menuSeries);
        ejecutarAccionBoton(btnDocumentales, this::menuDocumentales);
        //Ejecutar menú
        JOptionPane.showMessageDialog(null, new Object[]{
            "¿Sobre qué deseas informarte?",
            btnPeliculas,
            btnSeries,
            btnDocumentales},
            "Menú Principal",
            JOptionPane.PLAIN_MESSAGE
        );
    }
    public void menuPeliculas(){
        //Configuraciones de los JButton
        advertencia();
        JButton btnPelicula1 = new JButton("La Odisea");
        JButton btnPelicula2 = new JButton("Spider-Man: Un Nuevo Día");
        JButton btnPelicula3 = new JButton("El Padrino");
        //Acciones de los JButton
        ejecutarAccionBoton(btnPelicula1, () -> mostrarInfoAudiovisual(peliculas.get(0),
            peliculas.get(0).getNombre()));
        ejecutarAccionBoton(btnPelicula2, () -> mostrarInfoAudiovisual(peliculas.get(1),
            peliculas.get(1).getNombre()));
        ejecutarAccionBoton(btnPelicula3, () -> mostrarInfoAudiovisual(peliculas.get(2),
            peliculas.get(2).getNombre()));
        //Mostrar menú
        JOptionPane.showMessageDialog(null, new Object[]{
            "Seleccione una opción: ",
            btnPelicula1,
            btnPelicula2,
            btnPelicula3},
            "Menú Principal",
            JOptionPane.PLAIN_MESSAGE
        );               
    }
    public void menuSeries(){
        //Configuraciones de los JButton
        advertencia();
        JButton btnSerie1 = new JButton("Stranger Things");
        JButton btnSerie2 = new JButton("The Witcher");
        JButton btnSerie3 = new JButton("Peaky Blinders");
        //Acciones de los JButton
        ejecutarAccionBoton(btnSerie1, () -> mostrarInfoAudiovisual(series.get(0),
            series.get(0).getNombre()));
        ejecutarAccionBoton(btnSerie2, () -> mostrarInfoAudiovisual(series.get(1),
            series.get(1).getNombre()));
        ejecutarAccionBoton(btnSerie3, () -> mostrarInfoAudiovisual(series.get(2),
            series.get(2).getNombre()));
        //Mostrar menú
        JOptionPane.showMessageDialog(null, new Object[]{
            "Seleccione una opción: ",
            btnSerie1,
            btnSerie2,
            btnSerie3},
            "Menú Principal",
            JOptionPane.PLAIN_MESSAGE
        );               
    }
    public void menuDocumentales(){
        //Configuraciones de los JButton
        advertencia();
        JButton btnDocumental1 = new JButton("Los Dinosaurios");
        JButton btnDocumental2 = new JButton("El Último Baile");
        JButton btnDocumental3 = new JButton("Nuestro Planeta");
        //Acciones de los JButton
        ejecutarAccionBoton(btnDocumental1, () -> mostrarInfoAudiovisual(documentales.get(0),
            documentales.get(0).getNombre()));
        ejecutarAccionBoton(btnDocumental2, () -> mostrarInfoAudiovisual(documentales.get(1),
            documentales.get(1).getNombre()));
        ejecutarAccionBoton(btnDocumental3, () -> mostrarInfoAudiovisual(documentales.get(2),
            documentales.get(2).getNombre()));
        //Mostrar menú
        JOptionPane.showMessageDialog(null, new Object[]{
            "Seleccione una opción: ",
            btnDocumental1,
            btnDocumental2,
            btnDocumental3},
            "Menú Principal",
            JOptionPane.PLAIN_MESSAGE
        );               
    }
    //Este método recibe un objeto de tipo Audiovisual para reutilizar código.
    //Si el objeto pertenece a una subclase que sobrescribe alguno de sus métodos,
    //se ejecutará la implementación correspondiente a esa subclase.
    public void mostrarInfoAudiovisual(Audiovisual audiovisual, String nombre){ //Recibe cualquier subclase de Audiovisual como argumento
        String[] encabezados = {"Dato", "Información"};
        String[][] datos = {                                            
            {"Nombre: ", audiovisual.getNombre()},
            {"Año de Filmación: ", String.valueOf(audiovisual.getAgnioFilmacion())},
            {"Director: ", audiovisual.getDirector()},
            {"País de Origen: ", audiovisual.getPaisOrigen()},
            {"Duración: ", audiovisual.getDuracion()},
            {"Protagonistas: ", audiovisual.getProtagonistas()},
            {"Actores: ", audiovisual.getActores()},
            {"Calificación: ", String.valueOf(audiovisual.getCalificacion())}
            };                                                                  
        JTable infoAudiovisual = new JTable(datos, encabezados);                //Nuevo JTable
        infoAudiovisual.setPreferredSize(new Dimension(500, 300));              //Cambiar dimensiones de la ventana
        //Botones de la ventana (Comentar y Atrás)
        JButton btnComentar = new JButton("Comentar");
        JButton btnAtras = new JButton("Atrás");
        //Acciones de los botones
        btnComentar.addActionListener(e -> {
            String comentario = JOptionPane.showInputDialog(
                    null, "Ingrese su comentario: ");
            audiovisual.agregarComentario(comentario);
        });
        ejecutarAccionBoton(btnAtras, this::menuPrincipal);
        //Creación de un JPanel para mostrar la información
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnComentar);
        panelBotones.add(btnAtras);
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(new JScrollPane(infoAudiovisual), BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
                
        JOptionPane.showMessageDialog(null,
            panelPrincipal,
            "Información de "+nombre,
            JOptionPane.INFORMATION_MESSAGE
            );
    }
    public void ejecutarAccionBoton(JButton nombreBoton, Runnable accion){
        nombreBoton.addActionListener(e ->{
            cerrarVentana(nombreBoton);
            accion.run();
        });
        ;
    }
    public void cerrarVentana(JButton nombreBoton){
        Window ventana = SwingUtilities.getWindowAncestor(nombreBoton);
        ventana.dispose();
    }
    public void advertencia(){
        JOptionPane.showMessageDialog(null, "Esta es una prueba de concepto;"
                + " solo se muestran tres ejemplos.");
    }
}
