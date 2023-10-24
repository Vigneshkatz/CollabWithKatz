package com.katziio.collabwithkatz.dto.editor;

import com.katziio.collabwithkatz.entity.editor.EditorPreference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorPreferenceDTO {
    private Long id;
    private String projectPreferences;
    public EditorPreferenceDTO(EditorPreference editorPreference)
    {
        this.id=editorPreference.getId();
        this.projectPreferences=editorPreference.getProjectPreferences();
    }
}
