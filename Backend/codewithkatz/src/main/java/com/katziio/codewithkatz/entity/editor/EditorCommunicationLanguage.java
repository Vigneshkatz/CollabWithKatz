package com.katziio.codewithkatz.entity.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorCommunicationLanguage {
    private Long id;
    private String language;
    private int launguageProficency;
}
