package com.katziio.collabwithkatz.service.editorservice;

import com.katziio.collabwithkatz.dto.editordto.EditorDTO;
import com.katziio.collabwithkatz.dto.editordto.EditorPreferenceDTO;
import com.katziio.collabwithkatz.dto.editordto.EditorProjectDTO;
import com.katziio.collabwithkatz.entity.editor.Editor;
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
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    public EditorDTO deleteEditor(Long editorId) {
        Optional<Editor> editor = this.editorRepository.findById(editorId);
        if(editor.isPresent())
        {
            this.editorRepository.deleteById(editorId);
            return new EditorDTO(editor.get());
        }
        return null;

    }

    public EditorDTO updateEditor(Editor toUpdateEditor, Long editorId) {
        Optional<Editor> editor = this.editorRepository.findById(editorId);
        if(editor.isPresent())
        {
            Editor editor1 =  new Editor(toUpdateEditor);
            this.editorRepository.save(editor1);
        }
        return null;
    }

    public EditorDTO saveEditor(Editor editor) {
        this.editorRepository.save(editor);
        return new EditorDTO(editor);
    }

    public List<EditorDTO> getAllEditors() {
        List<EditorDTO> editorDTOList = new ArrayList<>();
        List<Editor> editorList = this.editorRepository.findAll();
        if(editorList.size()>1) {
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
            return  new EditorDTO(editor.get());
        }
        return null;
    }

    // TODO: 03/09/23
    public List<EditorDTO> searchEditorByName(String name) {
        return this.editorRepository.findEditorByName(name);
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

    public List<EditorProjectDTO> getProjectByEditorId(Long editorId) {
        return this.editorRepository.findProjectByEditorId(editorId);
    }


    public List<EditorDTO> getEditorsByGender(String gender) {
        return this.editorRepository.filterByGender(gender);
    }

    public Long countTotalEditors() {
        return this.editorRepository.countTotalNoOfEditor();
    }

    public EditorDTO getEditorByEmail(String email) {
        return this.editorRepository.getEditorByEmail(email);
    }

    public List<EditorDTO> getEditorByExperienceRange(int minExperience, int maxExperience) {
       return this.editorRepository.filterByExperience(minExperience,maxExperience);
    }

    public EditorDTO isValidUser(String userEmail, String userPassword) {
        return this.editorRepository.isValidLogin(userEmail,userPassword);
    }
}
