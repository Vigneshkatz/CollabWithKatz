package com.katziio.codewithkatz.dto;

import com.katziio.codewithkatz.entity.editor.EditorSocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorSocialMediaDTO {
    private Long id;
    private String platform;
    private String platformLink;

    public EditorSocialMediaDTO(EditorSocialMedia editorSocialMedia)
    {
        this.id=editorSocialMedia.getId();
        this.platform=editorSocialMedia.getPlatform();
        this.platformLink=editorSocialMedia.getPlatformLink();
    }
}
