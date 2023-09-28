package com.katziio.collabwithkatz.controller.editor;

import com.katziio.collabwithkatz.controller.creator.CreatorController;
import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/editors")
@CrossOrigin("*")
public class EditorController {
    Logger logger = LoggerFactory.getLogger(EditorController.class);

    @Autowired
    private EditorService editorService;

    //    get all user
    @GetMapping("/allEditors")
    public List<EditorDTO> getAllEditors() {
        return this.editorService.getAllEditors();
    }

    //    get user by id
    @GetMapping("/editorById")
    public EditorDTO getEditorsById(@RequestParam Long id) {
        return this.editorService.getEditorById(id);
    }

    //    add editor
    @PostMapping("/addEditor")
    public EditorDTO saveEditor(@RequestBody Editor editor) {
        return this.editorService.saveEditor(editor);
    }

    //    update editor
    @PutMapping("/updateEditor")
    public EditorDTO updateEditor(@RequestBody Editor editor, @RequestParam Long editorId) {
        return this.editorService.updateEditor(editor, editorId);
    }

    //    delete editor
    @DeleteMapping("/deleteMapping")
    public EditorDTO deleteEditor(@RequestParam Long editorId) {
        return this.editorService.deleteEditor(editorId);
    }

    //    Search Editors by Name:
    @GetMapping("/searchByName")
    public List<EditorDTO> searchEditorByName(@RequestParam String name) {
        return this.editorService.searchEditorByName(name);
    }

//    Filter Editors by Age Range:
    @GetMapping("/filterByAge")
    public List<EditorDTO> filterEditorByAge(@RequestParam int minAge,@RequestParam int maxAge) {
        return this.editorService.filterEditorByAge(minAge,maxAge);
    }

//    Filter Editors by Country
    @GetMapping("/filterByCountry")
    public List<EditorDTO> filterEditorByCountry(@RequestParam String countryName) {
        return this.editorService.filterEditorByCountry(countryName);
    }
//    Sort Editors by Experience
    @GetMapping("/sortBy/{sortBy}")
    public List<EditorDTO> sortEditorsByExperience(@PathVariable String sortBy) {
        return this.editorService.sortEditorsBy(sortBy);
//        return this.editorService.sortEditorsByExperience();
    }
//    Retrieve Editors by Gender
    @GetMapping("/filterByGender")
    public List<EditorDTO> getEditorsByGender(@RequestParam String gender) {
        return this.editorService.getEditorsByGender(gender);
    }
//    Count Total Editors:
    @GetMapping("/editorsCount")
    public Long countTotalEditors() {
        return this.editorService.countTotalEditors();
    }
//    Retrieve Editors by Email
    @GetMapping("/byEmail")
    public EditorDTO getEditorByEmail(@RequestParam String email) {
        return this.editorService.getEditorByEmail(email);
    }
//    Retrieve Editors by Experience Range
    @GetMapping("/byExperienceRange")
    public List<EditorDTO> getEditorByExperienceRange(@RequestParam int minExperience,@RequestParam int maxExperience) {
        return this.editorService.getEditorByExperienceRange(minExperience,maxExperience);
    }
    @GetMapping("/login")
    public EditorDTO isValidUser(@RequestParam String email,@RequestParam String password) {
        return this.editorService.isValidUser(email,password);
    }

    @GetMapping("{editorId}/getProjects")
    public List<ProjectDTO> getProjectsByCreatorId(@PathVariable Long editorId)
    {
        return this.editorService.getProjectByEditorId(editorId);
    }
//    Retrieve Editors Created After a Specific Date

//    Retrieve Editors Updated After a Specific Date:

//    Retrieve Editors by Portfolio Link

//    Retrieve Editors with Certifications

//    Retrieve Editors Speaking a Specific Language

//    Retrieve Editors by Age and Country

//    Retrieve Editors by Multiple Filters

//    Retrieve Editors with Most Experience

//    Retrieve Editors with Least Experience

//    Retrieve Editors Ordered by Creation Date

//    Add/Edit/Delete Editor's Certifications

//    Add/Edit/Delete Editor's Sample Videos:

//    Add/Edit/Delete Editor's Social Media Links

//    Update Editor's Profile Picture URL


}
