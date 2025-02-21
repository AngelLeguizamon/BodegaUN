package com.mycompany.bodegaun;

import view.LoginFrame;
import javax.swing.SwingUtilities;


public class BodegaUN {

    public static void main(String[] args) {
        
        System.out.println("Bodega UN INICIADA CORRECTAMENTE!");
        
        // Inicializamos la conexión con Firebase
        FirebaseInitializer.initialize();
        
        // Ejecutamos la interfaz gráfica 
        SwingUtilities.invokeLater(() -> {
            new LoginFrame(); // Inicia con la pantalla de login
        });  
    } 
}
