package com.katziio.codewithkatz.service.editor;

import com.katziio.codewithkatz.dto.EditorDTO;
import com.katziio.codewithkatz.entity.editor.Editor;
import com.katziio.codewithkatz.repository.editor.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;
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

    public List<EditorDTO> searchEditorByName(String name) {
        return null
    }

    public List<EditorDTO> filterEditorByAge(int minAge, int maxAge) {
        return null;
    }

    public List<EditorDTO> filterEditorByCountry(String countryName) {
        return null;
    }

    public List<EditorDTO> sortEditorsByExperience() {
        return null;
    }

    public List<EditorDTO> getProjectByEditorId(Long editorId) {
        return null;
    }

    public List<EditorDTO> getPreferenceByEditorId(Long editorId) {
        return null;
    }
}
