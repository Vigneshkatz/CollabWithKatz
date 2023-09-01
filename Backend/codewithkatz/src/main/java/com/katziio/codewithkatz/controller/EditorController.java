package com.katziio.codewithkatz.controller;

import com.katziio.codewithkatz.dto.EditorDTO;
import com.katziio.codewithkatz.entity.Editor;
import com.katziio.codewithkatz.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cwk")
@CrossOrigin("*")
public class EditorController {
    @Autowired
    private EditorService editorService;

    @GetMapping("/getEditors")
    public List<EditorDTO> getAllEditors(){
        return this.editorService.getAllEditors();
    }

    @PostMapping("/addEditor")
    public EditorDTO addEditor(@RequestBody Editor editor)
    {
        return this.editorService.addEditor(editor);
    }

    @PutMapping("/editEditor/{editorId}")
    public EditorDTO updateEditor(@RequestBody Editor editor,@PathVariable Long editorId)
    {
        return this.editorService.updateEditor(editor,editorId);
    }

    @DeleteMapping("/removeUser/{editorId}")
    public EditorDTO deleteEditor(@PathVariable Long editorId)
    {
        return this.editorService.deleteEditor(editorId);
    }
}
