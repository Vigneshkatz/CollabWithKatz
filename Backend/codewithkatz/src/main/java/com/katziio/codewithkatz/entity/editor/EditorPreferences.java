package com.katziio.codewithkatz.entity.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorPreferences {
    private Long id;
    private String projectPreferences;
}
