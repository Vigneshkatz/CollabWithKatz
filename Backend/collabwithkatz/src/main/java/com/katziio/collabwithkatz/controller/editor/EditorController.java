package com.katziio.collabwithkatz.controller.editor;

import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.service.editor.EditorService;
import com.katziio.collabwithkatz.service.firebase.FireBaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/editors")
@CrossOrigin("*")
public class EditorController {

    @Autowired
    private EditorService editorService;

    @GetMapping("/all")
    public ResponseEntity<List<EditorDTO>> getAllEditors() {
        List<EditorDTO> editors = editorService.getAllEditors();
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorDTO> getEditorById(@RequestParam Long id) {
        EditorDTO editor = editorService.getEditorById(id);
        return new ResponseEntity<>(editor, HttpStatus.OK);
    }

    @PutMapping("/update/{editorId}")
    public ResponseEntity<EditorDTO> updateEditor(@PathVariable Long editorId,
                                                  @Valid @RequestBody Editor updateRequest){
        EditorDTO updatedEditor = editorService.updateEditor(updateRequest, editorId);
        return new ResponseEntity<>(updatedEditor, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<EditorDTO> deleteEditor(@RequestParam Long editorId) {
        EditorDTO deletedEditor = editorService.deleteEditor(editorId);
        return new ResponseEntity<>(deletedEditor, HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<EditorDTO>> searchEditorsByName(@RequestParam String name) {
        List<EditorDTO> editors = editorService.searchEditorByName(name);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/filterByAge")
    public ResponseEntity<List<EditorDTO>> filterEditorsByAge(@RequestParam int minAge, @RequestParam int maxAge) {
        List<EditorDTO> editors = editorService.filterEditorByAge(minAge, maxAge);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/filterByCountry")
    public ResponseEntity<List<EditorDTO>> filterEditorsByCountry(@RequestParam String countryName) {
        List<EditorDTO> editors = editorService.filterEditorByCountry(countryName);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/sortBy/{sortBy}")
    public ResponseEntity<List<EditorDTO>> sortEditorsByExperience(@PathVariable String sortBy) {
        List<EditorDTO> editors = editorService.sortEditorsBy(sortBy);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/filterByGender")
    public ResponseEntity<List<EditorDTO>> getEditorsByGender(@RequestParam String gender) {
        List<EditorDTO> editors = editorService.getEditorsByGender(gender);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("/editorsCount")
    public ResponseEntity<Long> countTotalEditors() {
        Long count = editorService.countTotalEditors();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<EditorDTO> getEditorByEmail(@RequestParam String email) {
        EditorDTO editor = editorService.getEditorByEmail(email);
        return new ResponseEntity<>(editor, HttpStatus.OK);
    }

    @GetMapping("/byExperienceRange")
    public ResponseEntity<List<EditorDTO>> getEditorByExperienceRange(@RequestParam int minExperience, @RequestParam int maxExperience) {
        List<EditorDTO> editors = editorService.getEditorByExperienceRange(minExperience, maxExperience);
        return new ResponseEntity<>(editors, HttpStatus.OK);
    }

    @GetMapping("{editorId}/getProjects")
    public ResponseEntity<List<ProjectDTO>> getProjectsByEditorId(@PathVariable Long editorId) {
        List<ProjectDTO> projects = editorService.getProjectByEditorId(editorId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

}
