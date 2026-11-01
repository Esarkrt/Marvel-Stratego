
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {

    public MenuInicial() {
        setTitle("Marvel Stratego - Menú Inicial");
        setSize(550, 650);
        setMinimumSize(new Dimension(450, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color colorFondo = new Color(25, 30, 40);
        getContentPane().setBackground(colorFondo);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(colorFondo);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        try {
            ImageIcon iconoLogo = new ImageIcon(getClass().getResource("/Marvel.png"));
            Image imgOriginal = iconoLogo.getImage();

            int nuevoAncho = 380;
            double factorEscala = (double) nuevoAncho / imgOriginal.getWidth(null);
            int nuevoAlto = (int) (imgOriginal.getHeight(null) * factorEscala);

            Image imagenEscalada = imgOriginal.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            JLabel lblLogo = new JLabel(new ImageIcon(imagenEscalada));
            lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelCentro.add(lblLogo);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del logo.");
        }

        panelCentro.add(Box.createVerticalStrut(20));

        JLabel lblTitulo = new JLabel("MARVEL STRATEGO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(lblTitulo);

        panelCentro.add(Box.createVerticalStrut(35));

        JButton btnLogin = new JButton("LOG IN");
        JButton btnCrearPlayer = new JButton("CREAR PLAYER");

        btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
        btnCrearPlayer.setFont(new Font("Arial", Font.BOLD, 15));

        Dimension tamañoBoton = new Dimension(260, 48);
        btnLogin.setMaximumSize(tamañoBoton);
        btnCrearPlayer.setMaximumSize(tamañoBoton);
        btnLogin.setPreferredSize(tamañoBoton);
        btnCrearPlayer.setPreferredSize(tamañoBoton);

        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrearPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnLogin.addActionListener((ActionEvent e) -> {
            String user = JOptionPane.showInputDialog(this, "Ingrese Username:");
            if (user != null && !user.trim().isEmpty()) {
                String pass = JOptionPane.showInputDialog(this, "Ingrese Password:");
                if (pass != null) {
                    Jugador j = registroUser.autenticar(user, pass);
                    if (j != null) {
                        registroUser.setUserslogueados(j);
                        JOptionPane.showMessageDialog(this, "¡Bienvenido " + j.getUsername() + "!");
                        dispose();
                        new MenuPrincipal().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Credenciales inválidas.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnCrearPlayer.addActionListener((ActionEvent e) -> {
            boolean existe;
            String user;

            do {
                existe = false;
                user = JOptionPane.showInputDialog(this, "Ingrese Username:");
                if (user == null) {
                    return; 
                }
                
                if (user.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No puede dejar el campo vacío.", "Error de Registro", JOptionPane.WARNING_MESSAGE);
                    existe = true; 
                    continue;
                }

                for (Jugador j : registroUser.getUsuarios()) {
                    if (j.getUsername().equalsIgnoreCase(user.trim())) {
                        existe = true;
                        break;
                    } else {
                        
                    }
                }
                if (existe) {
                    JOptionPane.showMessageDialog(this, "El nombre de usuario ya está registrado.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
                }
            } while (existe);

            String pass = JOptionPane.showInputDialog(this, "Ingrese Password (exactamente 5 caracteres):");
            if (pass != null) {
                try {
                    registroUser.registrarUsuario(user, pass);
                    JOptionPane.showMessageDialog(this, "¡Jugador creado exitosamente!");
                } catch (DuplicatedNameException | InvalidPasswordException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelCentro.add(btnLogin);
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(btnCrearPlayer);

        add(panelCentro, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuInicial().setVisible(true);
        });
    }
}
