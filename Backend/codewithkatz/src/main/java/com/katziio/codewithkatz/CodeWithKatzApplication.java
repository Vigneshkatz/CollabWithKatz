package com.katziio.codewithkatz;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

@SpringBootApplication
public class CodeWithKatzApplication {

    public static void main(String[] args) throws Exception {
        String absolutePath = "/home/katziio/Desktop/CollabWithKatz/Backend/codewithkatz/src/main/resources/serviceKey.json";
        String BASE_DB_URL = "https://console.firebase.google.com/u/0/project/collabwithkatz/firestore/data/~2F";
        FileInputStream serviceAccount = new FileInputStream(absolutePath);
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(BASE_DB_URL).build();
            if (FirebaseApp.getApps().isEmpty()) { //<--- check with this line
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(CodeWithKatzApplication.class, args);
    }

}

