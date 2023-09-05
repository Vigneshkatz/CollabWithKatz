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

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(CodeWithKatzApplication.class, args);
    }
}

