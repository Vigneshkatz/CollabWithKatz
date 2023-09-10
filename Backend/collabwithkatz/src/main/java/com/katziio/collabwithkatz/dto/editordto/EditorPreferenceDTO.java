package com.katziio.collabwithkatz.dto.editordto;

import com.katziio.collabwithkatz.entity.editorentity.EditorPreferences;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorPreferenceDTO {
    private Long id;
    private String projectPreferences;
    public EditorPreferenceDTO(EditorPreferences editorPreference)
    {
        this.id=editorPreference.getId();
        this.projectPreferences=editorPreference.getProjectPreferences();
    }
}
