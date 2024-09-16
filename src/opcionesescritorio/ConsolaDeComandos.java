package opcionesescritorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConsolaDeComandos extends JFrame {
    private JTextArea consolaArea;
    private JTextField comandoField;
    private File directorioActual;

    public ConsolaDeComandos() {
        setTitle("Consola de Comandos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        consolaArea = new JTextArea();
        consolaArea.setEditable(false);
        consolaArea.setBackground(Color.BLACK); // Fondo negro
        consolaArea.setForeground(Color.WHITE); // Texto blanco
        JScrollPane scrollPane = new JScrollPane(consolaArea);

        comandoField = new JTextField();
        comandoField.setBackground(Color.BLACK); // Fondo negro
        comandoField.setForeground(Color.WHITE); // Texto blanco
        comandoField.setCaretColor(Color.WHITE); // Color del cursor
        comandoField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarComando(comandoField.getText());
                comandoField.setText("");
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(comandoField, BorderLayout.SOUTH);

         directorioActual = new File("./Mini_Windows/Mini_Windows/src/Z/Abraham");
        actualizarConsola();
    }

    private void procesarComando(String comando) {
        if (comando.startsWith("mkdir ")) {
            crearCarpeta(comando.substring(6));
        } else if (comando.startsWith("rm ")) {
            eliminarCarpeta(comando.substring(3));
        } else if (comando.startsWith("cd ")) {
            cambiarDirectorio(comando.substring(3));
        } else if (comando.equals("cd..")) {
            regresarDirectorio();
        } else if (comando.equals("dir")) {
            listarArchivos();
        } else if (comando.equals("date")) {
            mostrarFecha();
        } else if (comando.equals("time")) {
            mostrarHora();
        } else {
            consolaArea.append("Comando no reconocido: " + comando + "\n");
        }
    }

    private void crearCarpeta(String nombre) {
        File nuevaCarpeta = new File(directorioActual, nombre);
        if (nuevaCarpeta.mkdir()) {
            consolaArea.append("Carpeta creada: " + nombre + "\n");
        } else {
            consolaArea.append("No se pudo crear la carpeta: " + nombre + "\n");
        }
    }

    private void eliminarCarpeta(String nombre) {
        File carpeta = new File(directorioActual, nombre);
        if (carpeta.delete()) {
            consolaArea.append("Carpeta eliminada: " + nombre + "\n");
        } else {
            consolaArea.append("No se pudo eliminar la carpeta: " + nombre + "\n");
        }
    }

    private void cambiarDirectorio(String nombre) {
        File nuevoDirectorio = new File(directorioActual, nombre);
        if (nuevoDirectorio.isDirectory()) {
            directorioActual = nuevoDirectorio;
            actualizarConsola();
        } else {
            consolaArea.append("No es un directorio válido: " + nombre + "\n");
        }
    }

    private void regresarDirectorio() {
        File padre = directorioActual.getParentFile();
        if (padre != null) {
            directorioActual = padre;
            actualizarConsola();
        } else {
            consolaArea.append("Ya estás en el directorio raíz.\n");
        }
    }

    private void listarArchivos() {
        consolaArea.append("Contenido del directorio: " + directorioActual.getAbsolutePath() + "\n");
        for (File archivo : directorioActual.listFiles()) {
            consolaArea.append((archivo.isDirectory() ? "<DIR>" : "     ") + " " + archivo.getName() + "\n");
        }
    }

    private void mostrarFecha() {
        consolaArea.append("Fecha actual: " + java.time.LocalDate.now() + "\n");
    }

    private void mostrarHora() {
        consolaArea.append("Hora actual: " + java.time.LocalTime.now() + "\n");
    }

    private void actualizarConsola() {
        consolaArea.append("Directorio actual: " + directorioActual.getAbsolutePath() + "\n");
    }

    
}
