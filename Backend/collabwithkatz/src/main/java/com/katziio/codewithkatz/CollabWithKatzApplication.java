package com.katziio.codewithkatz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class CollabWithKatzApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(CollabWithKatzApplication.class, args);
    }
}

