package com.mycompany.bodegaun;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {
    public static void initialize() {
        try {
            // Lee el archivo de credenciales (asegúrate de que la ruta sea correcta)
            FileInputStream serviceAccount = new FileInputStream("src/main/recursos/firebase-service-account.json");
            
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bodegaun-1353c-default-rtdb.firebaseio.com/") // Reemplaza con la URL de tu base
                .build();
                
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase se ha inicializado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al inicializar Firebase: " + e.getMessage());
        }
    }
}
