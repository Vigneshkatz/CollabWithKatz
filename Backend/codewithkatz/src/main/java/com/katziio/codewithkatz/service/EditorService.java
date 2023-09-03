package com.katziio.codewithkatz.service;

import com.katziio.codewithkatz.dto.EditorDTO;
import com.katziio.codewithkatz.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepo;

    public List<EditorDTO> getAllEditors() {
        List<Editor> editorList = this.editorRepo.findAll();
        return editorList.stream().map(EditorDTO::new).collect(Collectors.toList());
    }

    public EditorDTO addEditor(Editor editor) {
        this.editorRepo.save(editor);
        return new EditorDTO(editor);
    }

    public EditorDTO updateEditor(Editor editor, Long editorId) {
        Optional<Editor> optionalEditor = this.editorRepo.findById(editorId);
        if (optionalEditor.isPresent()) {
            Editor dbEditor = optionalEditor.get();
            dbEditor.setName(editor.getName());
            dbEditor.setWebsite(editor.getWebsite());
            dbEditor.setPassword(editor.getPassword());
            dbEditor.setEmail(editor.getEmail());
            this.editorRepo.save(dbEditor);
            return new EditorDTO(dbEditor);
        }
        return null;
    }

    public EditorDTO deleteEditor(Long editorId) {
        Optional<Editor> optionalEditor = this.editorRepo.findById(editorId);
        if (optionalEditor.isPresent())
        {
            this.editorRepo.deleteById(editorId);
            return new EditorDTO(optionalEditor.get());
        }
        return null;
    }
}
