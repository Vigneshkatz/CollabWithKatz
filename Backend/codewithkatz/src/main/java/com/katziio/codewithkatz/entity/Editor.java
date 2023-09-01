package com.katziio.codewithkatz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Editor")
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String email;
    private String password;
    private String name;
    private String website;
}
