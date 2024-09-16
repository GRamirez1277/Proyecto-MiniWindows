package opcionesescritorio;

import javax.swing.*;
import java.io.File;

public class VisorDeCarpetas extends JFrame {

    public VisorDeCarpetas() {
        // Configurar el JFrame
        setTitle("Visor de Carpetas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear un JFileChooser que inicie desde la carpeta deseada
        JFileChooser fileChooser = new JFileChooser(new File("C:\\Users\\julio\\Downloads\\Mini_Windows\\Mini_Windows\\src\\Z\\Abraham"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo permite seleccionar directorios

        // Agregar el JFileChooser al JFrame
        add(fileChooser);

        setVisible(true);
    }

   
}
