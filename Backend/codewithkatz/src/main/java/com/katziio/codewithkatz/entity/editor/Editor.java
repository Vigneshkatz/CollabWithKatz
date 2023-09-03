package com.katziio.codewithkatz.entity.editor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editor {
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
}
