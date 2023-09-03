package com.katziio.codewithkatz.entity.editor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "editors")
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Date profileUpdatedAt;

    @OneToMany(targetEntity = EditorCertification.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorCertification> editorCertifications;

    @OneToMany(targetEntity = EditorCommunicationLanguage.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorCommunicationLanguage> editorCommunicationLanguages;

    @OneToMany(targetEntity = EditorPreferences.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorPreferences> editorPreferences;

    @OneToMany(targetEntity = EditorProject.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorProject> editorProjects;

    @OneToMany(targetEntity = EditorSampleVideo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSampleVideo> editorSampleVideos;

    @OneToMany(targetEntity = EditorSocialMedia.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSocialMedia> editorSocialMedia;

    public Editor(Editor editor) {
        Calendar myCal = Calendar.getInstance();
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
        this.portfolioLink=editor.getPortfolioLink();
        this.profileCreatedAt = editor.getProfileCreatedAt();
        this.profileUpdatedAt = myCal.getTime();
        this.editorCommunicationLanguages= editor.getEditorCommunicationLanguages();
        this.editorPreferences=editor.getEditorPreferences();
        this.editorProjects=editor.getEditorProjects();
        this.editorSampleVideos=editor.getEditorSampleVideos();
        this.editorSocialMedia=editor.getEditorSocialMedia();
    }
}
