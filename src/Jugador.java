
public class Jugador {
    private String username;
    private String password;
    private int puntos;
    private int partidasHEROES;
    private int partidasVILLANOS;

    public Jugador(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.partidasHEROES = 0;
        this.partidasVILLANOS = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPartidasHEROES() {
        return partidasHEROES;
    }

    public int getPartidasVILLANOS() {
        return partidasVILLANOS;
    }

    
    
}
