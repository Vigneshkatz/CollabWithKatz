package com.katziio.codewithkatz.entity.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorCertification {
    private Long id;
    private String certificationName;
    private String cetificationLink;
}
