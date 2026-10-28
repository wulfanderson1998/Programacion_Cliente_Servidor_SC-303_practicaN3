package fideflix;
import javax.swing.*;
import java.awt.*;

/**
 * Autor: Wulf Scott Anderson Prado
 * Universidad: Fidélitas
 * Curso: Programación Cliente/Servidor Concurrente SC-303
 */
public class Comentario {
    //Atributos de comentario
    protected int calificacion;
    protected String comentario;
    protected Usuario usuario;
    //Constructor de comentarios
    public Comentario(String comentario, Usuario usuario) {
        this.usuario = usuario;
        JButton[] estrellas = new JButton[5];                                   //Para mejorar el diseño, se usan JButtons con forma de estrella
        JOptionPane panel = new JOptionPane(                                    //Generar un menú para mostrar después
            "Seleccione su calificación:",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            null
        );
        for (int i = 0; i < estrellas.length; i++) {                            //Configuraciones de botones con forma de estrella
            final int nota = i + 1;
            estrellas[i] = new JButton("★");
            estrellas[i].setFont(new Font("Dialog", Font.PLAIN, 32));
            estrellas[i].setToolTipText(nota + " de 5 estrellas");
            estrellas[i].addActionListener(e -> {
                this.calificacion = nota;                                       //Acciones ejecutadas
                panel.setValue(nota);                                           //Cierra el diálogo
            });
        }
        //Actualiza las opciones después de crear los botones
        panel.setOptions(estrellas);
        //Mostrar ventana con calificaciones
        JDialog ventana = panel.createDialog(null, "Calificación");
        ventana.setVisible(true);
        ventana.dispose();
        if (this.calificacion == 0) {                                           //Si cierra la ventana sin seleccionar, queda en 0.
            this.comentario = "";
            return;
        }
        //Mostrar ventana para solicitar comentario
        this.comentario = comentario;
    }
    //Getters y Setters
    public int getCalificacion() {
        return calificacion;
    }
    public String getComentario() {
        return comentario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}