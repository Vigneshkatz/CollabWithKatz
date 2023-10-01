package com.katziio.collabwithkatz.service.editor;

import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;

import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.exception.NoSuchUserException;
import com.katziio.collabwithkatz.repository.project.ProjectRepository;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private ProjectRepository projectRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    public EditorDTO deleteEditor(Long editorId) {
        Optional<Editor> editor = this.editorRepository.findById(editorId);
        if(editor.isPresent())
        {
            this.editorRepository.deleteById(editorId);
            return new EditorDTO(editor.get());
        }

        throw new NoSuchUserException(editorId);

    }

    public EditorDTO updateEditor(Editor toUpdateEditor, Long editorId) {
        Optional<Editor> editor = this.editorRepository.findById(editorId);
        if(editor.isPresent())
        {
            Editor editor1 =  new Editor(toUpdateEditor);
            this.editorRepository.save(editor1);
        }
        throw new NoSuchUserException(editorId);
    }

    public EditorDTO saveEditor(Editor editor) {
//        this.editorRepository.save(editor);
        return new EditorDTO(this.editorRepository.save(editor));
    }

    public List<EditorDTO> getAllEditors() {
        List<EditorDTO> editorDTOList = new ArrayList<>();
        List<Editor> editorList = this.editorRepository.findAll();
        if(!editorList.isEmpty()) {
            for (Editor editor : editorList) {
                editorDTOList.add(new EditorDTO(editor));
            }
            return editorDTOList;
        }
        return null;
    }

    public EditorDTO getEditorById(Long editorId) {
        Optional<Editor> editor = this.editorRepository.findById(editorId);
        if(editor.isPresent())
        {
            System.out.println(editor.get().toString());
            return new EditorDTO(editor.get());
        }
        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> searchEditorByName(String name) {
        List<EditorDTO> editorList = this.editorRepository.findEditorByName(name);
        if(!editorList.isEmpty())
        {
            return editorList;
        }
        throw new NoSuchUserException();

    }

    public List<EditorDTO> filterEditorByAge(int minAge, int maxAge) {
        return this.editorRepository.filterByAge(minAge,maxAge);
    }

    public List<EditorDTO> filterEditorByCountry(String countryName) {
        return this.editorRepository.filterByCountry(countryName);
    }

    public List<EditorDTO> sortEditorsByExperience() {
        return this.editorRepository.sortEditorsByExperience();
    }

    public List<EditorDTO> getEditorsByGender(String gender) {
        return this.editorRepository.filterByGender(gender);
    }

    public Long countTotalEditors() {
        return this.editorRepository.countTotalNoOfEditor();
    }

    public EditorDTO getEditorByEmail(String email) {
        EditorDTO editor = this.editorRepository.getEditorByEmail(email);
        if(editor!=null)
        {
            return editor;
        }
        throw new NoSuchUserException(email);

    }

    public List<EditorDTO> getEditorByExperienceRange(int minExperience, int maxExperience) {
       return this.editorRepository.filterByExperience(minExperience,maxExperience);
    }

    public EditorDTO isValidUser(String userEmail, String userPassword) {
        return this.editorRepository.isValidLogin(userEmail,userPassword);
    }

    public List<ProjectDTO> getProjectByEditorId(Long editorId)
    {
        List<Project> projectList = this.projectRepository.findByEditorId(editorId);
        if(!projectList.isEmpty()) {
            List<ProjectDTO> projectDTOList = new ArrayList<>();
            for (Project project : projectList) {
                projectDTOList.add(new ProjectDTO(project));
            }

            return projectDTOList;
        }
        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> sortEditorsBy(String sortBy) {
        return this.editorRepository.sortEditorBy(sortBy);
    }
}
