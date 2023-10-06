package com.katziio.collabwithkatz.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

//@Configuration
public class FirebaseConfig {

    @Bean
    public static Storage initializeFirebaseApp() {
        ClassPathResource serviceAccount = new ClassPathResource("serviceKey.json");
        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.fromStream(serviceAccount.getInputStream());
            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
            return storage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
