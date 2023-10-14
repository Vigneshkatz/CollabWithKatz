package com.katziio.collabwithkatz.service.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.common.Project;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.exception.NoSuchUserException;
import com.katziio.collabwithkatz.exception.UserAlreadyExistsException;
import com.katziio.collabwithkatz.repository.creator.CreatorRepository;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import com.katziio.collabwithkatz.repository.project.ProjectRepository;
import com.katziio.collabwithkatz.service.editor.EditorService;
import com.katziio.collabwithkatz.service.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private EditorRepository editorRepository;
    @Autowired
    private EditorService editorService;
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public CreatorDTO addCreator(Creator creator) {
        Creator creatorCheck = this.creatorRepository.findByEmailVerify(creator.getEmail());
        if (creatorCheck== null) {
            creator.setConfirmationToken(UUID.randomUUID().toString());
            this.emailSenderService.initiateEmail(creator.getConfirmationToken(),creator.getEmail(),true);
            System.out.println("Creator successful Registration");
            return new CreatorDTO(creatorRepository.save(creator));
        }
        throw new UserAlreadyExistsException(creator.getEmail());
    }

    public CreatorDTO updateCreator(Creator creator, Long id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            creatorRepository.save(creator);
            return new CreatorDTO(creator);
        }
        throw new NoSuchUserException(id);
    }

    public CreatorDTO deleteCreator(Long id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            creatorRepository.deleteById(id);
            return new CreatorDTO(optionalCreator.get());
        }
        throw new NoSuchUserException(id);
    }

    public CreatorDTO getCreatorById(Long id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            creatorRepository.findById(id);
            return new CreatorDTO(optionalCreator.get());
        }
        throw new NoSuchUserException(id);
    }

    public Creator getCreatorByIdForMapping(Long id) {
        Optional<Creator> optionalCreator = creatorRepository.findById(id);
        if (optionalCreator.isPresent()) {
            return optionalCreator.get();
        }
        throw new NoSuchUserException(id);
    }

    public ProjectDTO addProject(Project project, Long creatorId, Long editorId) {
        Editor editor = editorService.getEditorByIdForMapping(editorId);
        Creator creator = getCreatorByIdForMapping(editorId);
        project.setCreator(creator);
        project.setEditor(editor);
        projectRepository.save(project);
        return new ProjectDTO(project);
    }

    public List<ProjectDTO> getProjectsByCreatorId(Long creatorId) {
        List<Project> projectList = projectRepository.findByCreatorId(creatorId);
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project : projectList) {
            projectDTOList.add(new ProjectDTO(project));
        }
        return projectDTOList;
    }

    public List<ProjectDTO>  getNotAssignedProjects() {
        List<Project> projectList = projectRepository.findProjectsWithNoEditor();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project : projectList) {
            projectDTOList.add(new ProjectDTO(project));
        }
        return projectDTOList;
    }

    public CreatorDTO isValidUser(String email, String password) {
        CreatorDTO creatorDTO = creatorRepository.isValidLogin(email, password);
        if (creatorDTO != null) {
            return creatorRepository.isValidLogin(email, password);
        }
        throw new NoSuchUserException(email, password);
    }

    public CreatorDTO getCreatorByEmail(String email) {
        CreatorDTO creatorDTO = creatorRepository.findByEmail(email);
        if (creatorDTO != null) {
            return creatorDTO;
        }
        throw new NoSuchUserException(email);
    }
    public Creator verifyAccount(String confirmationToken)
    {
        Creator creator = this.creatorRepository.findByConfirmationToken(confirmationToken);
        if (creator != null) {
            creator.setVerified(true);
            creator.setConfirmationToken(null);
            this.creatorRepository.save(creator);
//            System.out.println("heibfdsvbisuhv");
            return creator;
        } else {
            throw new NoSuchUserException();
        }
    }
}
