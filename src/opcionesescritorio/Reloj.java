package opcionesescritorio;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.Color;

public class Reloj extends Thread {
    private JLabel labelFecha;
    private JLabel labelHora;

    public Reloj(JLabel labelFecha, JLabel labelHora) {
        this.labelFecha = labelFecha;
        this.labelHora = labelHora;

        // Establece el color de la fuente a blanco
        this.labelFecha.setForeground(Color.WHITE);
        this.labelHora.setForeground(Color.WHITE);
    }

    @Override
    public void run() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        
        while (true) {
            // Obtén la fecha y hora actuales
            Date fechaActual = new Date();
            
            // Actualiza los labels
            labelFecha.setText(formatoFecha.format(fechaActual));
            labelHora.setText(formatoHora.format(fechaActual));

            try {
                // Actualiza cada segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
