package com.katziio.collabwithkatz.controller.editor;

import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.common.Review;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.entity.editor.EditorSampleVideo;
import com.katziio.collabwithkatz.entity.editor.EditorSocialMedia;
import com.katziio.collabwithkatz.service.editor.EditorService;
import com.katziio.collabwithkatz.service.firebase.FireBaseService;
import com.katziio.collabwithkatz.service.upvote.UpvoteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
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

    @Autowired
    private UpvoteService upvoteService;

    @GetMapping("/all")
    public ResponseEntity<List<Editor>> getAllEditors(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        List<Editor> editorPage = editorService.getAllEditors(page, size);
        return new ResponseEntity<>(editorPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorDTO> getEditorById(@RequestParam Long id) {
        EditorDTO editor = editorService.getEditorById(id);
        return new ResponseEntity<>(editor, HttpStatus.OK);
    }

    @PutMapping("/update/{editorId}")
    public ResponseEntity<EditorDTO> updateEditor(@PathVariable Long editorId,
                                                  @Valid @RequestBody Editor updateRequest) {
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

    @GetMapping("{editorId}/upvote")
    public ResponseEntity<Long> getEditorUpvote(@PathVariable Long editorId) {
        Long upvoteCount = this.upvoteService.getEditorUpvoteCount(editorId);
        return new ResponseEntity<>(upvoteCount, HttpStatus.OK);
    }

    @PostMapping("/review/add/{editorId}/{creatorId}")
    public Review addReview(@PathVariable Long editorId,
                            @PathVariable Long creatorId,
                            @RequestParam String review) {
        return this.editorService.addReview(editorId, creatorId, review);
    }

    @GetMapping("/review/get/{editorId}")
    public List<Review> getAllReviewsOFEditor(@PathVariable Long editorId, @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return this.editorService.getEditorReviewList(editorId, page, size);
    }

    @DeleteMapping("/review/delete/{editorId}/{creatorId}")
    public Boolean deleteCreatorReview(@PathVariable Long creatorId, @PathVariable Long editorId) {
        return this.editorService.deleteReview(creatorId, editorId);
    }

    @PostMapping("/{editorId}/myvideo/add")
    public List<EditorSampleVideo> addMyVideo(@PathVariable Long editorId, @RequestBody List<EditorSampleVideo> editorSampleVideoList) {
        return this.editorService.addMyVideo(editorId, editorSampleVideoList);
    }

    @GetMapping("/{editorId}/myvideo/get")
    public List<EditorSampleVideo> getMyVideo(@PathVariable Long editorId) {
        return this.editorService.getMyVideo(editorId);
    }

    @PostMapping("/{editorId}/social/add")
    public List<EditorSocialMedia> addSocialMedia(@PathVariable Long editorId,@RequestBody List<EditorSocialMedia> editorSocialMediaList)
    {
        return this.editorService.addSocialMedia(editorId,editorSocialMediaList);
    }

    @GetMapping("/{editorId}/social/get")
    public List<EditorSocialMedia> getSocialMedia(@PathVariable Long editorId)
    {
        return this.editorService.getSocialMedia(editorId);
    }

}