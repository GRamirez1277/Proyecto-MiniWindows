package opcionesescritorio;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ventanaprincipal.ventana;

public class CrearUsuario extends JPanel {

    private JButton botonCrear = new JButton("Crear");
    private JTextField campoUsuario = new JTextField();
    private JPasswordField campoContraseña = new JPasswordField();
    private JLabel etiquetaCrearUser = new JLabel("Crear Usuario");
    private JLabel etiquetaUsuario = new JLabel("Usuario: ");
    private JLabel etiquetaContraseña = new JLabel("Contraseña");
    private JLabel usuarioExiste = new JLabel("El usuario que ha ingresado ya existe.");
    private JButton botonRegresar = new JButton("Regresar");

    private Font fuenteLogin = new Font("Elephant", Font.BOLD, 50);
    private Font usuarioContraseña = new Font("Elephant", Font.BOLD, 30);
    private Font fuenteEtiquetas = new Font("Elephant", Font.PLAIN, 15);

    private ventana ventanaPrincipal;  // Referencia a la ventana principal

    public CrearUsuario(ventana ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;  // Guardar la referencia a la ventana principal
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(800, 600);  // Establecer el tamaño fijo del JPanel

        usuarioExiste.setForeground(Color.RED);
        usuarioExiste.setFont(fuenteEtiquetas);
        usuarioExiste.setBounds(250, 100, 350, 100);  // Ajustar posición
        usuarioExiste.setVisible(false); // Inicialmente oculto
        add(usuarioExiste);

        botonRegresar.setFont(new Font("Elephant", Font.BOLD, 20));
        botonRegresar.setForeground(Color.BLACK);
        botonRegresar.setBackground(Color.RED);
        botonRegresar.setBounds(30, 500, 180, 50);  // Ajustar posición
        add(botonRegresar);

        botonCrear.setBounds(650, 500, 100, 50);  // Ajustar posición
        botonCrear.setBackground(Color.WHITE);
        botonCrear.setFont(new Font("Elephant", Font.BOLD, 20));
        botonCrear.setForeground(Color.BLACK);
        add(botonCrear);

        etiquetaCrearUser.setForeground(Color.ORANGE);
        etiquetaUsuario.setForeground(Color.ORANGE);
        etiquetaContraseña.setForeground(Color.ORANGE);

        etiquetaCrearUser.setBounds(250, 20, 500, 100);  // Ajustar posición
        etiquetaUsuario.setBounds(250, 200, 300, 100);  // Ajustar posición
        etiquetaContraseña.setBounds(250, 350, 300, 100);  // Ajustar posición

        etiquetaCrearUser.setFont(fuenteLogin);
        etiquetaUsuario.setFont(usuarioContraseña);
        etiquetaContraseña.setFont(usuarioContraseña);

        add(etiquetaCrearUser);
        add(etiquetaUsuario);
        add(etiquetaContraseña);

        campoUsuario.setBounds(550, 225, 200, 50);  // Ajustar posición
        campoContraseña.setBounds(550, 375, 200, 50);  // Ajustar posición

        add(campoUsuario);
        add(campoContraseña);

        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contraseña = new String(campoContraseña.getPassword());

                if ("Abraham".equals(usuario) && "admin".equals(contraseña)) {
                    usuarioExiste.setVisible(false);
                    System.out.println("Usuario creado: " + usuario);
                    campoUsuario.setText("");
                    campoContraseña.setText("");
                } else {
                    usuarioExiste.setVisible(true);
                }
            }
        });

        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar el formulario actual
                CrearUsuario.this.getTopLevelAncestor().setVisible(false);
                // Hacer visible la ventana principal
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}
