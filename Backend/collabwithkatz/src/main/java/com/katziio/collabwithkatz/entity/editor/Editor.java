package com.katziio.collabwithkatz.entity.editor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Size(max = 500)
    private String about;
    @Column(unique = true)
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
    private boolean isVerified;
    @Column(name = "confirmation_token")
    private String confirmationToken;

    @OneToMany(targetEntity = EditorCertification.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorCertification> certificationList;

    @OneToMany(targetEntity = EditorCommunicationLanguage.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorCommunicationLanguage> communicationLanguageList;

    @OneToMany(targetEntity = EditorSampleVideo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSampleVideo> sampleVideoList;

    @OneToMany(targetEntity = EditorSocialMedia.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSocialMedia> socialMediaList;

    @OneToMany(targetEntity = EditorSkill.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSkill> skillList;

    @OneToMany(targetEntity = EditorPreference.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorPreference> preferencesList;

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
        this.certificationList = editor.getCertificationList();
        this.portfolioLink=editor.getPortfolioLink();
        this.profileCreatedAt = editor.getProfileCreatedAt();
        this.profileUpdatedAt = myCal.getTime();
        this.communicationLanguageList = editor.getCommunicationLanguageList();
        this.sampleVideoList=editor.getSampleVideoList();
        this.socialMediaList=editor.getSocialMediaList();
        this.isVerified = editor.isVerified();
        this.about = editor.getAbout();
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", experienceInYears=" + experienceInYears +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", portfolioLink='" + portfolioLink + '\'' +
                ", profileCreatedAt=" + profileCreatedAt +
                ", profileUpdatedAt=" + profileUpdatedAt +
                '}';
    }
}
