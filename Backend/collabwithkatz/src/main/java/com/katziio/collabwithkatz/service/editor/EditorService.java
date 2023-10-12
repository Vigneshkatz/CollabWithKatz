package com.katziio.collabwithkatz.service.editor;

import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.exception.NoSuchUserException;
import com.katziio.collabwithkatz.exception.UserAlreadyExistsException;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import com.katziio.collabwithkatz.repository.project.ProjectRepository;
import com.katziio.collabwithkatz.service.email.EmailSenderService;
import com.katziio.collabwithkatz.service.firebase.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class EditorService {
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public EditorDTO deleteEditor(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            editorRepository.deleteById(editorId);
            return new EditorDTO(editor.get());
        }

        throw new NoSuchUserException(editorId);
    }

    public EditorDTO updateEditor(Editor toUpdateEditor, Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            Editor dbEditor = editor.get();
            if(toUpdateEditor.getName()!=null)
            {
                dbEditor.setName(toUpdateEditor.getName());
            }
            if(toUpdateEditor.getAge()!=0)
            {
                dbEditor.setAge(toUpdateEditor.getAge());
            }
            if(toUpdateEditor.getExperienceInYears()!=0)
            {
                dbEditor.setExperienceInYears(toUpdateEditor.getExperienceInYears());
            }
            if(!toUpdateEditor.getAbout().isEmpty())
            {
                dbEditor.setAbout(toUpdateEditor.getAbout());
            }
            if(!toUpdateEditor.getCountry().isEmpty())
            {
                dbEditor.setCountry(toUpdateEditor.getCountry());
            }
            if(!toUpdateEditor.getPhone().isEmpty())
            {
                dbEditor.setPhone(toUpdateEditor.getPhone());
            }
            if(!toUpdateEditor.getPhone().isEmpty())
            {
                dbEditor.setPhone(toUpdateEditor.getPhone());
            }
            if(!toUpdateEditor.getProfilePictureUrl().isEmpty())
            {
                dbEditor.setProfilePictureUrl(toUpdateEditor.getProfilePictureUrl());
            }
            if(!toUpdateEditor.getProfilePictureUrl().isEmpty())
            {
                dbEditor.setProfilePictureUrl(toUpdateEditor.getProfilePictureUrl());
            }
            Date updatedDate = Calendar.getInstance().getTime();
            dbEditor.setProfileUpdatedAt(updatedDate);
            Editor editorToUpdate = new Editor(dbEditor);
            return new EditorDTO(editorRepository.save(editorToUpdate));
        }else {
            throw new NoSuchUserException(editorId);
        }
    }

    public EditorDTO saveEditor(Editor editor)  {
       Editor editorCheck = this.editorRepository.findByEmail(editor.getEmail());
        if (editorCheck == null) {
            editor.setConfirmationToken(UUID.randomUUID().toString());
            System.out.println(editor.getEmail());
            EditorDTO editorDTO = new EditorDTO(editorRepository.save(editor));
            this.emailSenderService.initiateEmail(editor.getConfirmationToken(),editor.getEmail(),false);
            System.out.println("Editor successful Registration");
            return editorDTO;
        }
       throw new UserAlreadyExistsException(editor.getEmail());

    }

    public List<EditorDTO> getAllEditors() {
        List<EditorDTO> editorDTOList = new ArrayList<>();
        List<Editor> editorList = editorRepository.findAll();
        if (!editorList.isEmpty()) {
            for (Editor editor : editorList) {
                editorDTOList.add(new EditorDTO(editor));
            }
            return editorDTOList;
        }

        return null;
    }

    public EditorDTO getEditorById(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            return new EditorDTO(editor.get());
        }

        throw new NoSuchUserException(editorId);
    }

    public Editor getEditorByIdForMapping(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            return editor.get();
        }

        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> searchEditorByName(String name) {
        List<EditorDTO> editorList = editorRepository.findEditorByName(name);
        if (!editorList.isEmpty()) {
            return editorList;
        }

        throw new NoSuchUserException();
    }

    public List<EditorDTO> filterEditorByAge(int minAge, int maxAge) {
        return editorRepository.filterByAge(minAge, maxAge);
    }

    public List<EditorDTO> filterEditorByCountry(String countryName) {
        return editorRepository.filterByCountry(countryName);
    }

    public List<EditorDTO> sortEditorsByExperience() {
        return editorRepository.sortEditorsByExperience();
    }

    public List<EditorDTO> getEditorsByGender(String gender) {
        return editorRepository.filterByGender(gender);
    }

    public Long countTotalEditors() {
        return editorRepository.countTotalNoOfEditor();
    }

    public EditorDTO getEditorByEmail(String email) {
        EditorDTO editor = editorRepository.getEditorByEmail(email);
        if (editor != null) {
            return editor;
        }

        throw new NoSuchUserException(email);
    }

    public List<EditorDTO> getEditorByExperienceRange(int minExperience, int maxExperience) {
        return editorRepository.filterByExperience(minExperience, maxExperience);
    }

    public EditorDTO isValidUser(String userEmail, String userPassword) {
        return editorRepository.isValidLogin(userEmail, userPassword);
    }

    public List<ProjectDTO> getProjectByEditorId(Long editorId) {
        List<Project> projectList = projectRepository.findByEditorId(editorId);
        if (!projectList.isEmpty()) {
            List<ProjectDTO> projectDTOList = new ArrayList<>();
            for (Project project : projectList) {
                projectDTOList.add(new ProjectDTO(project));
            }
            return projectDTOList;
        }

        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> sortEditorsBy(String sortBy) {
        return editorRepository.sortEditorBy(sortBy);
    }

    public Editor verifyAccount(String confirmationToken)
    {
        Editor editor = this.editorRepository.findByConfirmationToken(confirmationToken);
        if (editor != null) {
            editor.setVerified(true);
            editor.setConfirmationToken(null);
            this.editorRepository.save(editor);
            System.out.println("heibfdsvbisuhv");
            return editor;
        } else {
           throw new NoSuchUserException();
        }
    }
}
