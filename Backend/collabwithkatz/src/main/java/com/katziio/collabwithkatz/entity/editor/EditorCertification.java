package com.katziio.collabwithkatz.entity.editor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editor_certifications")
public class EditorCertification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String certificationName;
    private String certificationLink;
}
