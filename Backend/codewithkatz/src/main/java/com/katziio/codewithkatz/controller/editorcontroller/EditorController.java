package com.katziio.codewithkatz.controller.editorcontroller;

import com.katziio.codewithkatz.dto.editordto.EditorDTO;
import com.katziio.codewithkatz.dto.editordto.EditorPreferenceDTO;
import com.katziio.codewithkatz.dto.editordto.EditorProjectDTO;
import com.katziio.codewithkatz.entity.editorentity.Editor;
import com.katziio.codewithkatz.service.editorservice.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/editor")
@CrossOrigin("*")
public class EditorController {
    @Autowired
    private EditorService editorService;


    //    get all user
    @GetMapping("/allEditors")
    public List<EditorDTO> getAllEditors() {
        return this.editorService.getAllEditors();
    }

    //    get user by id
    @GetMapping("/editors")
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
    @GetMapping("/sortByExperience")
    public List<EditorDTO> sortEditorsByExperience() {
        return this.editorService.sortEditorsByExperience();
    }
//    Get Editor's Projects
    @GetMapping("/{editorId}/projects")
    public List<EditorProjectDTO> getProjectByEditorId(@PathVariable Long editorId) {
        return this.editorService.getProjectByEditorId(editorId);
    }

//    Retrieve Editor's Preferences
    @GetMapping("/{editorId}/preference")
    public List<EditorPreferenceDTO> getPreferenceByEditorId(@PathVariable Long editorId) {
        return this.editorService.getPreferenceByEditorId(editorId);
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
