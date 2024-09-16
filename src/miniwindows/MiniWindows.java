package miniwindows;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import usuarios.Usuarios;
import ventanaprincipal.VentanaLogin;

public class MiniWindows {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Crear y mostrar la ventana de login
        JFrame loginFrame = new JFrame("Login");
        VentanaLogin ventanaLogin = new VentanaLogin();
        
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 600);
        loginFrame.setResizable(false);
        loginFrame.setContentPane(ventanaLogin);
        loginFrame.setVisible(true);


        Usuarios usuarios = new Usuarios();
        
        // Llamar al método para mostrar los usuarios en la consola
        System.out.println("Usuarios almacenados:");
        usuarios.mostrarUsuarios(); // Invocar la función para mostrar los usuarios
        
    }
}
