package com.katziio.collabwithkatz.dto.creator;

import com.katziio.collabwithkatz.entity.creator.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long id;
    private String projectName;
    private String projectDescription;
    private String rawVideoURl;
    private String editedVideoURL;
    private Long creatorId;
    private Long editorId;

    public ProjectDTO(Project project)
    {
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.projectDescription = project.getProjectDescription();
        this.editedVideoURL = project.getEditedVideoURL();
        this.rawVideoURl = project.getRawVideoURl();
        this.creatorId=project.getCreatorId();
        this.editorId = project.getEditorId();
    }
}