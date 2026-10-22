import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MenuInicial extends JFrame{
    ArrayList<String> Registro = new ArrayList<>();
    JPanel panel;
    JButton boton1, boton2;

    public MenuInicial() {
        boton1=new JButton("LOG IN");
        boton2=new JButton("CREAR JUGADOR");
        ImageIcon img=new ImageIcon("Marvel.png");
        Image logoesc=img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icofin=new ImageIcon(logoesc);
        JLabel Logo=new JLabel(icofin);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("MARVEL STRATEGO");
        this.setResizable(false);
        this.setLocation(650, 200);
        ImageIcon logo=new ImageIcon("Marvel.png");
        this.setIconImage(logo.getImage());
        this.setLayout(new BorderLayout());
        panel=new JPanel();
        panel.setBackground(Color.lightGray);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(Logo);
        Logo.setBounds(200,20 , 200, 200);
        Logo.setVisible(true);
        panel.setLayout(null);
        boton1.setBounds(150, 250, 150, 40);
        boton2.setBounds(320, 250, 150, 40);
        this.add(panel,BorderLayout.CENTER);

    }


}
