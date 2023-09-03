package com.katziio.codewithkatz.entity.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorSkill {
    private Long id;
    private String aboutSkill;
    private String availability;
    private String flexibility;
    private String technicalProficiency;
    private String equipmentDetails;
}
