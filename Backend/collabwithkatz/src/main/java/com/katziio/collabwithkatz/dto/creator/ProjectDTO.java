package com.katziio.collabwithkatz.dto.creator;

import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.editor.Editor;
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
    private Creator creator;
    private Editor editor;

    public ProjectDTO(Project project)
    {
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.projectDescription = project.getProjectDescription();
        this.creator=project.getCreator();
        this.editor = project.getEditor();
        this.rawVideoURl = project.getRawVideoURl();
    }
}
