package com.katziio.collabwithkatz.entity.editor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "editor_skill")
public class EditorSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String aboutSkill;
    private String availability;
    private String flexibility;
    private String technicalProficiency;
    private String equipmentDetails;
}
