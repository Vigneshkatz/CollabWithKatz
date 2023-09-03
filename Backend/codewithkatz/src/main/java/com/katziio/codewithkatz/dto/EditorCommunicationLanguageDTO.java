package com.katziio.codewithkatz.dto;

import com.katziio.codewithkatz.entity.editor.EditorCommunicationLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorCommunicationLanguageDTO {
    private Long id;
    private String language;
    private int languageProficiency;
    public EditorCommunicationLanguageDTO(EditorCommunicationLanguage editorCommunicationLanguage)
    {
        this.id=editorCommunicationLanguage.getId();
        this.languageProficiency=editorCommunicationLanguage.getLanguageProficiency();
        this.language=editorCommunicationLanguage.getLanguage();
    }
}
