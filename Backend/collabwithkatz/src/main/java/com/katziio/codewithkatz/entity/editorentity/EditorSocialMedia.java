package com.katziio.codewithkatz.entity.editorentity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editor_social_media")
public class EditorSocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String platform;
    private String platformLink;
}
