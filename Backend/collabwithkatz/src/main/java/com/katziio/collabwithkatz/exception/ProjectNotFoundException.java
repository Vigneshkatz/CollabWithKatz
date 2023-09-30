package com.katziio.collabwithkatz.dto.error;

public class ProjectNotFoundException extends RuntimeException {

    public  ProjectNotFoundException(){
        super("Project not found with");
    }
    public ProjectNotFoundException(Long projectId) {
        super("Project not found with ID: " + projectId);
    }
}
