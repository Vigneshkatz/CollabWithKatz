package com.katziio.codewithkatz.dto;

import com.katziio.codewithkatz.entity.editor.Editor;
import com.katziio.codewithkatz.entity.editor.EditorCertification;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorCertificationDTO {
    private Long id;
    private String certificationName;
    private String certificationLink;

    public EditorCertificationDTO(EditorCertification editorCertification)
    {
        this.id=editorCertification.getId();
        this.certificationName=editorCertification.getCertificationName();
        this.certificationLink=editorCertification.getCertificationLink();
    }
}
