package opcionesescritorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleTextEditor extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;
    private File currentFile;

    public SimpleTextEditor() {
        setTitle("Simple Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Serif", Font.PLAIN, 14));  // Fuente predeterminada
        textArea.setForeground(Color.BLACK);  // Color predeterminado
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new OpenFileAction());
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveFileAction());
        fileMenu.add(saveMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitAction());
        fileMenu.add(exitMenuItem);

        JMenu formatMenu = new JMenu("Format");
        menuBar.add(formatMenu);

        JMenuItem fontMenuItem = new JMenuItem("Change Font");
        fontMenuItem.addActionListener(new FontAction());
        formatMenu.add(fontMenuItem);

        JMenuItem fontSizeMenuItem = new JMenuItem("Change Font Size");
        fontSizeMenuItem.addActionListener(new FontSizeAction());
        formatMenu.add(fontSizeMenuItem);

        JMenuItem fontColorMenuItem = new JMenuItem("Change Font Color");
        fontColorMenuItem.addActionListener(new FontColorAction());
        formatMenu.add(fontColorMenuItem);

        setJMenuBar(menuBar);
    }

    private class OpenFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = fileChooser.showOpenDialog(SimpleTextEditor.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                    textArea.read(reader, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(SimpleTextEditor.this, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class SaveFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentFile == null) {
                int result = fileChooser.showSaveDialog(SimpleTextEditor.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    currentFile = fileChooser.getSelectedFile();
                } else {
                    return;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(SimpleTextEditor.this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class FontAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar diálogo para seleccionar la fuente
            String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            String fontName = (String) JOptionPane.showInputDialog(
                SimpleTextEditor.this,
                "Select Font:",
                "Font Settings",
                JOptionPane.PLAIN_MESSAGE,
                null,
                fonts,
                textArea.getFont().getFamily()
            );

            if (fontName != null) {
                textArea.setFont(new Font(fontName, textArea.getFont().getStyle(), textArea.getFont().getSize()));
            }
        }
    }

    private class FontSizeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar diálogo para seleccionar el tamaño de la fuente
            String[] sizes = {"12", "14", "16", "18", "20", "24", "30"};
            String size = (String) JOptionPane.showInputDialog(
                SimpleTextEditor.this,
                "Select Font Size:",
                "Font Size Settings",
                JOptionPane.PLAIN_MESSAGE,
                null,
                sizes,
                textArea.getFont().getSize()
            );

            if (size != null) {
                int fontSize = Integer.parseInt(size);
                textArea.setFont(new Font(textArea.getFont().getFamily(), textArea.getFont().getStyle(), fontSize));
            }
        }
    }

    private class FontColorAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar diálogo para seleccionar el color de la fuente
            Color textColor = JColorChooser.showDialog(
                SimpleTextEditor.this,
                "Select Text Color",
                textArea.getForeground()
            );

            if (textColor != null) {
                textArea.setForeground(textColor);
            }
        }
    }

}
