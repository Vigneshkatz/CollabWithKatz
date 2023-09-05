package com.katziio.codewithkatz.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class FireBaseConfig {
    @Bean
    public FirebaseApp initializeFirebase() throws Exception {
        String absolutePath = "/home/katziio/Desktop/CollabWithKatz/Backend/codewithkatz/src/main/resources/serviceKey.json";
//        String BASE_DB_URL = "https://console.firebase.google.com/u/0/project/collabwithkatz/firestore/data/~2Feditors";
        String BASE_DB_URL = "https://console.firebase.google.com/u/0/project/collabwithkatz/firestore/";
        FileInputStream serviceAccount = new FileInputStream(absolutePath);
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().
                    setCredentials(GoogleCredentials.fromStream(serviceAccount)).
                    setDatabaseUrl(BASE_DB_URL).
                    build();
            if (FirebaseApp.getApps().isEmpty()) {
                return FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

