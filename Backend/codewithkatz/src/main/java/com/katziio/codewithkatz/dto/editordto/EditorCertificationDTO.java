package com.katziio.codewithkatz.dto.editordto;

import com.katziio.codewithkatz.entity.editorentity.EditorCertification;
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
