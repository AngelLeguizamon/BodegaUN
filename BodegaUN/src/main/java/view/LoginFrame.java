package view;

import com.mycompany.bodegaun.GoogleLogin;
import com.google.api.client.http.javanet.NetHttpTransport;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login Administrativo");
        setSize(300, 200);
        setLocationRelativeTo(null);// Se centra la ventana en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // panel con una dispocision de tabla de 3x2 casillas
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JLabel lblUsuario = new JLabel("Usuario:");
        JTextField txtUsuario = new JTextField();
        
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();
        
        JButton btnLogin = new JButton("Ingresar");
        JButton btnGoogleLogin = new JButton("Ingresar con Google");

        
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel("")); // Casilla vacía
        panel.add(btnLogin);
        panel.add(new JLabel("")); // Casilla vacia
        panel.add(btnGoogleLogin); 
       
        
// ================== Boton login con Google ==================================
        

        btnGoogleLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Inicializar el transporte HTTP necesario para el flujo OAuth2
                    final NetHttpTransport HTTP_TRANSPORT = new com.google.api.client.http.javanet.NetHttpTransport();
                    // Iniciar el proceso de autenticación
                    GoogleLogin.getCredentials(HTTP_TRANSPORT);
                    // Si la autenticación es exitosa, se puede proceder a abrir la ventana principal
                    JOptionPane.showMessageDialog(null, "Autenticación con Google exitosa.");
                    new Home(); // Abre la ventana principal
                    dispose();  // Cierra la ventana de login
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en la autenticación con Google: " + ex.getMessage());
                }
            }
        });  

// ===================== Hasta aca login Google ==================================
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());
                if(usuario.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Acceso concedido.");
                    new Home(); // Se abre la ventana principal
                    dispose();  // Se cierra la ventana de login
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
                }
            }
        });

// ===================== Hasta aca verificacion usuario predeterminado ===========

        
        add(panel);
        setVisible(true);
    }
}
