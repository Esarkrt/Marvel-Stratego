import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MenuInicial extends JFrame{
    ArrayList<String> Registro = new ArrayList<>();

    public MenuInicial() {

        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MARVEL STRATEGO");
        this.setResizable(false);
        this.setLocation(650, 200);
        ImageIcon logo=new ImageIcon("Marvel.png");
        this.setIconImage(logo.getImage());
        

    }


}
