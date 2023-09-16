package com.katziio.collabwithkatz.dto.editor;

import com.katziio.collabwithkatz.entity.creator.Project;
import com.katziio.collabwithkatz.entity.creator.Review;
import com.katziio.collabwithkatz.entity.creator.Upvote;
import com.katziio.collabwithkatz.entity.editor.*;
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
    private Date ProfileUpdatedAt;
    private List<EditorCertification> certificationsList;
    private List<EditorCommunicationLanguage> communicationLanguagesList;
    private List<EditorSampleVideo> sampleVideoList;
    private List<EditorSocialMedia> socialMediaList;
    private List<Project> projectList;
    private List<Upvote> upvoteList;
    private List<Review> reviewList;


    public EditorDTO(Editor editor) {
        this.id = editor.getId();
        this.name = editor.getName();
        this.about = editor.getAbout();
        this.password=editor.getPassword();
        this.email = editor.getEmail();
        this.age=editor.getAge();
        this.country = editor.getCountry();
        this.gender = editor.getCountry();
        this.experienceInYears = editor.getExperienceInYears();
        this.phone=editor.getPhone();
        this.profilePictureUrl=editor.getProfilePictureUrl();
        this.certificationsList= editor.getCertifications();
        this.communicationLanguagesList= editor.getCommunicationLanguages();
        this.projectList=editor.getProjectList();
        this.sampleVideoList=editor.getSampleVideoList();
        this.socialMediaList=editor.getSocialMediaList();
        this.reviewList = editor.getReviewList();
    }
}
