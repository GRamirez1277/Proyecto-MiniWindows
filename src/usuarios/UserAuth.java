package usuarios;

import java.util.ArrayList;

public class UserAuth {
    // Lista que almacenará los usuarios y contraseñas
    ArrayList<User> users;

    // Constructor
    public UserAuth() {
        users = new ArrayList<>();
    }

    // Método para agregar usuario a la lista
    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    // Método para verificar si el usuario y la contraseña son correctos
    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;  // Autenticación exitosa
            }
        }
        return false;  // Usuario o contraseña incorrectos
    }
    
    
    
}
