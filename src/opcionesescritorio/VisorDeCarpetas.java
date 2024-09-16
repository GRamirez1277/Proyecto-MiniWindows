package opcionesescritorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.Comparator;

public class VisorDeCarpetas extends JFrame {

    private JFileChooser fileChooser;
    private File archivoCopiado = null;
    private JList<File> fileList;
    private DefaultListModel<File> listModel;

    public VisorDeCarpetas() {
        setTitle("Visor de Carpetas");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configurar JFileChooser con la ruta inicial deseada
        fileChooser = new JFileChooser(new File("./src/Z/Abraham"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Permite seleccionar archivos y directorios

        // Configurar la lista de archivos
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(fileList);

        // Botones para operaciones
        JButton copiarButton = new JButton("Copiar");
        JButton pegarButton = new JButton("Pegar");
        JButton cambiarNombreButton = new JButton("Cambiar Nombre");
        JButton organizarButton = new JButton("Organizar");

        copiarButton.addActionListener(e -> copiarArchivo());
        pegarButton.addActionListener(e -> pegarArchivo());
        cambiarNombreButton.addActionListener(e -> cambiarNombreArchivo());
        organizarButton.addActionListener(e -> organizarArchivos());

        // Configurar el layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        panel.add(copiarButton);
        panel.add(pegarButton);
        panel.add(cambiarNombreButton);
        panel.add(organizarButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        actualizarLista(); // Inicializar la lista de archivos
        setVisible(true);
    }

    private void copiarArchivo() {
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            archivoCopiado = fileChooser.getSelectedFile();
        }
    }

    private void pegarArchivo() {
        int returnValue = fileChooser.showOpenDialog(this);
        if (archivoCopiado != null && returnValue == JFileChooser.APPROVE_OPTION) {
            File directorioDestino = fileChooser.getSelectedFile();
            if (directorioDestino.isDirectory()) {
                File destino = new File(directorioDestino, archivoCopiado.getName());
                try {
                    Files.copy(archivoCopiado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    actualizarLista();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un directorio.");
            }
        }
    }

    private void cambiarNombreArchivo() {
        File archivoSeleccionado = fileList.getSelectedValue();
        if (archivoSeleccionado != null) {
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                File renamedFile = new File(archivoSeleccionado.getParentFile(), nuevoNombre);
                if (archivoSeleccionado.renameTo(renamedFile)) {
                    actualizarLista();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al renombrar el archivo");
                }
            }
        }
    }

    private void organizarArchivos() {
        String[] opciones = {"Nombre", "Fecha", "Tipo", "Tamaño"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Organizar por:", "Organizar", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion != null) {
            List<File> archivos = Collections.list(listModel.elements()); // Conversión de DefaultListModel a List<File>
            
            // Ordenar según la opción seleccionada
            switch (seleccion) {
                case "Nombre":
                    archivos.sort(Comparator.comparing(File::getName));
                    break;
                case "Fecha":
                    archivos.sort(Comparator.comparingLong(File::lastModified));
                    break;
                case "Tipo":
                    archivos.sort(Comparator.comparing(f -> {
                        String nombre = f.getName();
                        int idx = nombre.lastIndexOf('.');
                        return (idx == -1) ? "" : nombre.substring(idx + 1);
                    }));
                    break;
                case "Tamaño":
                    archivos.sort(Comparator.comparingLong(File::length));
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Opción no válida.");
                    return;
            }
            
            // Limpiar y actualizar la lista con los archivos ordenados
            listModel.clear();
            archivos.forEach(listModel::addElement);
        }
    }

    private void actualizarLista() {
        listModel.clear();
        File directorioActual = fileChooser.getCurrentDirectory();
        if (directorioActual != null && directorioActual.isDirectory()) {
            File[] archivos = directorioActual.listFiles();
            if (archivos != null) {
                Arrays.sort(archivos);
                for (File archivo : archivos) {
                    listModel.addElement(archivo);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VisorDeCarpetas::new);
    }
}
