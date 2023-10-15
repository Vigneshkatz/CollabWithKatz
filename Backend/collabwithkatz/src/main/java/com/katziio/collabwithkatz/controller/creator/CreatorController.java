package com.katziio.collabwithkatz.controller.creator;

import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.entity.common.Project;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.service.creator.CreatorService;
import com.katziio.collabwithkatz.service.upvote.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/creators")
@CrossOrigin("*")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private UpvoteService upvoteService;


    @PutMapping("/update/{id}")
    public ResponseEntity<CreatorDTO> updateCreator(@RequestBody Creator creator, @PathVariable Long id) {
        CreatorDTO updatedCreator = creatorService.updateCreator(creator, id);
        return new ResponseEntity<>(updatedCreator, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CreatorDTO> deleteCreator(@PathVariable Long id) {
        CreatorDTO deletedCreator = creatorService.deleteCreator(id);
        return new ResponseEntity<>(deletedCreator, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreatorDTO> getCreatorById(@PathVariable Long id) {
        CreatorDTO creator = creatorService.getCreatorById(id);
        return new ResponseEntity<>(creator, HttpStatus.OK);
    }

    @PostMapping("/addProject/{creatorId}/{editorId}")
    public ResponseEntity<ProjectDTO> addProject(@RequestBody Project project, @PathVariable Long creatorId, @PathVariable Long editorId) {
        ProjectDTO addedProject = creatorService.addProject(project, creatorId, editorId);
        return new ResponseEntity<>(addedProject, HttpStatus.CREATED);
    }

    @PostMapping("/addProject/{creatorId}")
    public ResponseEntity<ProjectDTO> listProject(@RequestBody Project project, @PathVariable Long creatorId) {
        ProjectDTO addedProject = creatorService.listProject(project, creatorId);
        return new ResponseEntity<>(addedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{creatorId}/projects")
    public ResponseEntity<List<ProjectDTO>> getProjectsByCreatorId(@PathVariable Long creatorId) {
        List<ProjectDTO> projects = creatorService.getProjectsByCreatorId(creatorId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getNotAssignedProjects() {
        List<ProjectDTO> projects = creatorService.getNotAssignedProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PutMapping("/project/changeStatus/{status}")
    public ResponseEntity<ProjectDTO> changeProjectStatus(@PathVariable String status, @RequestParam Project project) {
        ProjectDTO projectUpdated = creatorService.changeProjectStatus(status, project);
        return new ResponseEntity<>(projectUpdated, HttpStatus.OK);
    }


    //    upvote
    @PutMapping("/upvote/changeStatus/{creatorId}/{editorId}")
    public ResponseEntity<Boolean> changeUpvoteStatus(@PathVariable Long editorId, @PathVariable Long creatorId) {
        Boolean isStatusChanged = upvoteService.changeUpvoteStatus(editorId, creatorId);
        return new ResponseEntity<>(isStatusChanged, HttpStatus.OK);
    }
}
