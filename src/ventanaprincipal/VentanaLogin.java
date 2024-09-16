package ventanaprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JPanel {

    public JButton botonLogin = new JButton("Login");

    public JTextField campoUsuario = new JTextField();
    public JPasswordField campoContraseña = new JPasswordField();

    public JLabel etiquetaLogin = new JLabel();
    public JLabel etiquetaUsuario = new JLabel();
    public JLabel etiquetaContraseña = new JLabel();

    public Font fuenteLogin = new Font("Roboto", Font.BOLD, 30);
    public Font usuarioContraseña = new Font("Roboto", Font.BOLD, 20);
    public Font fuenteEtiquetas = new Font("Roboto", Font.PLAIN, 15);

    public JLabel noExisteEquivocado = new JLabel("El usuario/contraseña que ha ingresado no existe o lo ha ingresado mal.");
    JLabel logo1 = new JLabel();
    JLabel logo2 = new JLabel();

    public VentanaLogin() {
        this.setLayout(null);

        // Configuración de componentes
        etiquetaLogin.setText("LOGIN");
        etiquetaUsuario.setText("Usuario: ");
        etiquetaContraseña.setText("Contraseña:");

        etiquetaLogin.setForeground(Color.BLACK);
        etiquetaUsuario.setForeground(Color.BLACK);
        etiquetaContraseña.setForeground(Color.BLACK);

        etiquetaLogin.setBounds(120, 10, 120, 50); // Mover el texto de login hacia abajo
        etiquetaUsuario.setBounds(200, 180, 100, 30); // Mover el texto de usuario hacia abajo
        etiquetaContraseña.setBounds(200, 240, 150, 30); // Mover el texto de contraseña hacia abajo

        etiquetaLogin.setFont(fuenteLogin);
        etiquetaUsuario.setFont(usuarioContraseña);
        etiquetaContraseña.setFont(usuarioContraseña);

        add(etiquetaLogin);
        add(etiquetaUsuario);
        add(etiquetaContraseña);

        campoUsuario.setBounds(320, 180, 200, 30); // Mover el campo de usuario hacia abajo
        campoContraseña.setBounds(320, 240, 200, 30); // Mover el campo de contraseña hacia abajo

        add(campoUsuario);
        add(campoContraseña);

        botonLogin.setBounds(320, 300, 100, 50); // Mover el botón hacia abajo
        botonLogin.setBackground(Color.WHITE);
        botonLogin.setFont(new Font("Roboto", Font.BOLD, 20));
        botonLogin.setForeground(Color.BLACK);

        add(botonLogin);

        noExisteEquivocado.setFont(fuenteEtiquetas);
        noExisteEquivocado.setForeground(Color.RED);
        noExisteEquivocado.setVisible(false);
        noExisteEquivocado.setBounds(200, 360, 400, 30); // Mover el mensaje de error hacia abajo

        add(noExisteEquivocado);

        logo1.setBounds(330, 10, 150, 100); // Mantener el logo en la parte superior derecha
        
        try {
            Image imagenEditorTexto = ImageIO.read(getClass().getResource("/imagenes/logo.png"));
            logo1.setIcon(new ImageIcon(imagenEditorTexto.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        add(logo1);
        
        
           logo2.setBounds(0, 0, 800, 600); // Mantener el logo en la parte superior derecha
        
        try {
            Image imagenEditorTexto = ImageIO.read(getClass().getResource("/imagenes/fondo.jpg"));
            logo2.setIcon(new ImageIcon(imagenEditorTexto.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        add(logo2);

        // Agregar ActionListener al botón de login
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contraseña = new String(campoContraseña.getPassword());
                  new ventana().setVisible(true);
                // Aquí debes agregar la lógica para verificar las credenciales
                if (verificarCredenciales(usuario, contraseña)) {
                    noExisteEquivocado.setVisible(false);
                    // Acciones a realizar si las credenciales son correctas
                      
                } else {
                    noExisteEquivocado.setVisible(true);
                    
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aquí puedes agregar el código para pintar el fondo si es necesario
    }

    // Método ficticio para verificar credenciales
    private boolean verificarCredenciales(String usuario, String contraseña) {
        // Reemplazar con la lógica real para verificar las credenciales
        return "admin".equals(usuario) && "password".equals(contraseña);
    }
}
