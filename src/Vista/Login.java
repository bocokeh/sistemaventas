package Vista;

import Modelo.LoginDAO;
import Modelo.login;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Objects;

public class Login extends javax.swing.JFrame {
    login lg = new login();
    LoginDAO login = new LoginDAO();

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void validar() {
        String correo = txtCorreo.getText();
        String pass = String.valueOf(txtPass.getPassword());
        if (!"".equals(correo) || !"".equals(pass)) {
            lg = login.log(correo, pass);
            if (lg.getCorreo() != null && lg.getPass() != null) {
                Sistema sis = new Sistema(lg);
                sis.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Panel principal del inicio de sesión
        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iniciar Sesión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(0, 0, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Etiqueta para Correo Electrónico
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Correo Electrónico");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 102, -1, -1));

        // Etiqueta para Contraseña
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, -1, -1));

        // Campo de texto para Correo
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 132, 226, 30));

        // Campo de texto para Contraseña
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 199, 226, 30));

        // Botón de iniciar sesión
        btnIniciar.setBackground(new java.awt.Color(0, 0, 204));
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Login");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 239, 93, 34));

        jLabelImagen.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Img/login_logo.png"))));
        jLabelImagen.setText("LogoEpicoPuntoYeipec");
        jPanel2.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 280, 380));

        javax.swing.JPanel panelImagen = new javax.swing.JPanel();
        panelImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelImagen.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 380));

        getContentPane().add(panelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 380));

        pack();
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        validar();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Declaración de variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jLabelImagen;
}
