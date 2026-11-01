
import java.util.ArrayList;


public class registroUser {
    private static ArrayList<Jugador>users=new ArrayList<>();
    private static Jugador userslogueados=null;

    public static Jugador getUserslogueados() {
        return userslogueados;
    }

    public static void setUserslogueados(Jugador userslogueados) {
        registroUser.userslogueados = userslogueados;
    }

    public static void registrarUsuario(String username, String password) 
            throws DuplicatedNameException, InvalidPasswordException {
            if (password == null || password.length() != 5) {
            throw new InvalidPasswordException(" La contraseña debe tener exactamente 5 caracteres.");
            
        }for (Jugador j : users) {
            if (j.getUsername().equalsIgnoreCase(username)) {
                throw new DuplicatedNameException(" El nombre de usuario ya está registrado.");
            }
        }
        users.add(new Jugador(username, password));
    }
    public static Jugador autenticar(String username, String password) {
        for (Jugador j : users) {
            if (j.getUsername().equalsIgnoreCase(username) && j.getPassword().equals(password)) {
                return j;
            }
        }
        return null;
    }
    public static ArrayList<Jugador> getUsuarios() {
        return users;
    }
}
    
    
    
    
