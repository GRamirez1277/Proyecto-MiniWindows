package usuarios;


import usuarios.UserAuth;

public class UserManagement extends UserAuth {

    // Método para registrar un nuevo usuario
    public boolean registerUser(String username, String password) {
        // Validar que el nombre de usuario no esté vacío
        if (username == null || username.isEmpty()) {
            System.out.println("El nombre de usuario no puede estar vacío.");
            return false;
        }

        // Validar que la contraseña no esté vacía
        if (password == null || password.isEmpty()) {
            System.out.println("La contraseña no puede estar vacía.");
            return false;
        }

        // Agregar el nuevo usuario
        addUser(username, password);
        System.out.println("Usuario creado exitosamente.");
        return true;
    }
    public void listUsers() {
        for (User user : users) {
            System.out.println("Usuario registrado: " + user.getUsername());
        }
    }
}
