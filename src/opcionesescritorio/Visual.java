package opcionesescritorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Visual extends JFrame {

    private Nodo head;
    private JLabel labelImagen;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JFileChooser fileChooser;
    private final String directorioImagenes = "./src/Z/Abraham/Imagenes";

    public Visual() {
        // Inicializa el visor con el directorio de imágenes
        head = null;
        fileChooser = new JFileChooser(directorioImagenes);

        // Configura la ventana principal
        setTitle("Visor de Imágenes");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura el JLabel para mostrar imágenes
        labelImagen = new JLabel();
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        updateImageLabel();

        // Configura el botón de "Añadir Imagen"
        JButton btnAñadir = new JButton("Añadir Imagen");
        btnAñadir.addActionListener(e -> {
            int opcion = fileChooser.showOpenDialog(this);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                guardarYAgregarImagen(archivoSeleccionado);
                updateImageLabel();
            }
        });

        // Configura el botón "Anterior"
        btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(e -> {
            retroceder();
            updateImageLabel();
        });

        // Configura el botón "Siguiente"
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> {
            avanzar();
            updateImageLabel();
        });

        // Añade los botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAnterior);
        panelBotones.add(btnAñadir);
        panelBotones.add(btnSiguiente);

        // Añade componentes a la ventana
        add(labelImagen, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Configura el MouseListener para la navegación con botones del ratón
        labelImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    retroceder();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    avanzar();
                }
                updateImageLabel();
            }
        });

        // Carga las imágenes desde el directorio
        cargarImagenesDesdeCarpeta();
    }

    private void agregarImagen(ImageIcon imagen) {
        Nodo nuevoNodo = new Nodo(imagen);
        if (head == null) {
            head = nuevoNodo;
            head.siguiente = head;
        } else {
            Nodo temp = head;
            while (temp.siguiente != head) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = head;
        }
    }

    private void avanzar() {
        if (head != null) {
            head = head.siguiente;
        }
    }

    private void retroceder() {
        if (head != null) {
            Nodo temp = head;
            while (temp.siguiente != head) {
                temp = temp.siguiente;
            }
            head = temp;
        }
    }

    private ImageIcon imagenActual() {
        return head != null ? head.imagen : null;
    }

    private void cargarImagenesDesdeCarpeta() {
        File carpeta = new File(directorioImagenes);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (esImagen(archivo)) {
                    agregarImagen(new ImageIcon(archivo.getAbsolutePath()));
                }
            }
        }
    }

    private boolean esImagen(File archivo) {
        String nombre = archivo.getName().toLowerCase();
        return nombre.endsWith(".jpg") || nombre.endsWith(".jpeg") || nombre.endsWith(".png") || nombre.endsWith(".gif");
    }

    private void guardarYAgregarImagen(File archivo) {
        try {
            Path destino = new File(directorioImagenes + "/" + archivo.getName()).toPath();
            Files.copy(archivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            agregarImagen(new ImageIcon(destino.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateImageLabel() {
        ImageIcon imagenActual = imagenActual();
        if (imagenActual != null) {
            ImageIcon imagenRedimensionada = redimensionarImagen(imagenActual);
            labelImagen.setIcon(imagenRedimensionada);
        } else {
            labelImagen.setIcon(null);
        }
    }

    private ImageIcon redimensionarImagen(ImageIcon icono) {
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(getWidth(), getHeight() - 100, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Visual visual = new Visual();
            visual.setVisible(true);
        });
    }

    // Clase Nodo para la lista circular
    private class Nodo {
        ImageIcon imagen;
        Nodo siguiente;

        Nodo(ImageIcon imagen) {
            this.imagen = imagen;
            this.siguiente = null;
        }
    }
}
