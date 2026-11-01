
import java.awt.*;
import javax.swing.*;


public class MenuPrincipal extends JFrame{
    JButton newGame,miPerfil,universoMarvel,cerrarSesion ;
    public MenuPrincipal(){
        setTitle("Marvel Stratego");
        setSize(550, 650);
        setMinimumSize(new Dimension(450, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
}
