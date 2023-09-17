package com.katziio.collabwithkatz.service.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.repository.creator.CreatorRepository;
import com.katziio.collabwithkatz.repository.creator.ProjectRepository;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private ProjectRepository projectRepository;
    public CreatorDTO addCreator(Creator creator) {
        creatorRepository.save(creator);
        return new CreatorDTO(creator);
    }

    public CreatorDTO updateCreator(Creator creator,Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
            this.creatorRepository.save(creator);
            return new CreatorDTO(creator);
        }
        return null;
    }

    public CreatorDTO deleteCreator(Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
           this.creatorRepository.deleteById(id);
           return new CreatorDTO(optionalCreator.get());
        }
        return null;
    }

    public CreatorDTO getCreatorById(Long id) {
        Optional<Creator> optionalCreator = this.creatorRepository.findById(id);
        if(optionalCreator.isPresent())
        {
            this.creatorRepository.deleteById(id);
            return new CreatorDTO(optionalCreator.get());
        }
        return null;
    }

    public ProjectDTO addProject(Project project) {
        this.projectRepository.save(project);
        return new ProjectDTO(project);
    }

    public List<ProjectDTO> getProjectByCreatorId(Long creatorId)
    {
        List<Project> projectList = this.projectRepository.findByCreatorId(creatorId);
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project:projectList)
        {
            projectDTOList.add(new ProjectDTO(project));
        }
        return projectDTOList;
    }
}
