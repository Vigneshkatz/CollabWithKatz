package com.katziio.collabwithkatz.entity.editor;

import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.creator.Review;
import com.katziio.collabwithkatz.entity.creator.Upvote;
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
    private String about;
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
    private List<EditorCertification> certifications;

    @OneToMany(targetEntity = EditorCommunicationLanguage.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorCommunicationLanguage> communicationLanguages;

    @OneToMany(targetEntity = EditorProject.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<Project> projectList;

    @OneToMany(targetEntity = EditorSampleVideo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSampleVideo> sampleVideoList;

    @OneToMany(targetEntity = EditorSocialMedia.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<EditorSocialMedia> socialMediaList;

    @OneToMany(targetEntity = Review.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<Review> reviewList;

    @OneToMany(targetEntity = Upvote.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_fk_id", referencedColumnName = "id")
    private List<Upvote> upvoteList;

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
        this.certifications= editor.getCertifications();
        this.portfolioLink=editor.getPortfolioLink();
        this.profileCreatedAt = editor.getProfileCreatedAt();
        this.profileUpdatedAt = myCal.getTime();
        this.communicationLanguages= editor.getCommunicationLanguages();
        this.projectList=editor.getProjectList();
        this.sampleVideoList=editor.getSampleVideoList();
        this.socialMediaList=editor.getSocialMediaList();
    }
}
