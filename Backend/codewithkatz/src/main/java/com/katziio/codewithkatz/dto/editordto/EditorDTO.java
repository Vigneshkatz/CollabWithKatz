package com.katziio.codewithkatz.dto.editordto;

import com.katziio.codewithkatz.entity.editorentity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int age;
    private String country;
    private String gender;
    private int experienceInYears;
    private String profilePictureUrl;
    private String phone;
    private String portfolioLink;
    private Date profileCreatedAt;
    private Date ProfileUpdatedAt;
    private List<EditorCertification> editorCertifications;
    private List<EditorCommunicationLanguage> editorCommunicationLanguages;
    private List<EditorPreferences> editorPreferences;
    private List<EditorProject> editorProjects;
    private List<EditorSampleVideo> editorSampleVideos;
    private List<EditorSocialMedia> editorSocialMedia;

    public EditorDTO(Editor editor) {
        this.id = editor.getId();
        this.name = editor.getName();
        this.password=editor.getPassword();
        this.email = editor.getEmail();
        this.age=editor.getAge();
        this.country = editor.getCountry();
        this.gender = editor.getCountry();
        this.experienceInYears = editor.getExperienceInYears();
        this.phone=editor.getPhone();
        this.profilePictureUrl=editor.getProfilePictureUrl();
        this.editorCertifications= editor.getEditorCertifications();
        this.editorCommunicationLanguages= editor.getEditorCommunicationLanguages();
        this.editorPreferences=editor.getEditorPreferences();
        this.editorProjects=editor.getEditorProjects();
        this.editorSampleVideos=editor.getEditorSampleVideos();
        this.editorSocialMedia=editor.getEditorSocialMedia();
    }
}
