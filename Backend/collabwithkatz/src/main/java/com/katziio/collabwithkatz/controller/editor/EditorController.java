package com.katziio.collabwithkatz.controller.editor;

//import com.katziio.collabwithkatz.config.jwt.JwtHelper;
import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.dto.jwt.JwtResponse;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/editors")
@CrossOrigin("*")
public class EditorController {


    @Autowired
    private AuthenticationManager manager;

//    @Autowired
//    private JwtHelper helper;


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

    //    update editor
    @PutMapping("/updateEditor")
    public EditorDTO updateEditor(@RequestBody Editor editor, @RequestParam Long editorId) {
        return this.editorService.updateEditor(editor, editorId);
    }

    //    delete editor
    @DeleteMapping("/delete")
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

    @GetMapping("{editorId}/getProjects")
    public List<ProjectDTO> getProjectsByCreatorId(@PathVariable Long editorId)
    {
        return this.editorService.getProjectByEditorId(editorId);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
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
