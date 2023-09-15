package com.katziio.collabwithkatz.dto.editordto;

import com.katziio.collabwithkatz.entity.editor.EditorSampleVideo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorSampleVideoDTO {
    private Long id;
    private String videoName;
    private String videoLink;

    public EditorSampleVideoDTO(EditorSampleVideo editorSampleVideo)
    {
        this.id=editorSampleVideo.getId();
        this.videoLink=editorSampleVideo.getVideoLink();
        this.videoName=editorSampleVideo.getVideoName();
    }
}
