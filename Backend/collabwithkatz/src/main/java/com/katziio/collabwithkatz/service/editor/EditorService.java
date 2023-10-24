package com.katziio.collabwithkatz.service.editor;

import com.katziio.collabwithkatz.dto.creator.ProjectDTO;
import com.katziio.collabwithkatz.dto.editor.EditorDTO;
import com.katziio.collabwithkatz.entity.common.Project;
import com.katziio.collabwithkatz.entity.common.Review;
import com.katziio.collabwithkatz.entity.editor.*;
import com.katziio.collabwithkatz.exception.NoSuchUserException;
import com.katziio.collabwithkatz.exception.UserAlreadyExistsException;
import com.katziio.collabwithkatz.repository.editor.EditorRepository;
import com.katziio.collabwithkatz.repository.project.ProjectRepository;
import com.katziio.collabwithkatz.repository.review.ReviewRepository;
import com.katziio.collabwithkatz.service.email.EmailSenderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EditorService {
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ReviewRepository reviewRepository;

    public EditorDTO deleteEditor(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            editorRepository.deleteById(editorId);
            return new EditorDTO(editor.get());
        }

        throw new NoSuchUserException(editorId);
    }

    public EditorDTO updateEditor(Editor toUpdateEditor, Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            Editor dbEditor = editor.get();
            if (toUpdateEditor.getName() != null) {
                dbEditor.setName(toUpdateEditor.getName());
            }
            if (toUpdateEditor.getAge() != 0) {
                dbEditor.setAge(toUpdateEditor.getAge());
            }
            if (toUpdateEditor.getExperienceInYears() != 0) {
                dbEditor.setExperienceInYears(toUpdateEditor.getExperienceInYears());
            }
            if (!toUpdateEditor.getAbout().isEmpty()) {
                dbEditor.setAbout(toUpdateEditor.getAbout());
            }
            if (!toUpdateEditor.getCountry().isEmpty()) {
                dbEditor.setCountry(toUpdateEditor.getCountry());
            }
            if (!toUpdateEditor.getPhone().isEmpty()) {
                dbEditor.setPhone(toUpdateEditor.getPhone());
            }
            if (!toUpdateEditor.getPhone().isEmpty()) {
                dbEditor.setPhone(toUpdateEditor.getPhone());
            }
            if (!toUpdateEditor.getProfilePictureUrl().isEmpty()) {
                dbEditor.setProfilePictureUrl(toUpdateEditor.getProfilePictureUrl());
            }
            if (!toUpdateEditor.getProfilePictureUrl().isEmpty()) {
                dbEditor.setProfilePictureUrl(toUpdateEditor.getProfilePictureUrl());
            }
            Date updatedDate = Calendar.getInstance().getTime();
            dbEditor.setProfileUpdatedAt(updatedDate);
            Editor editorToUpdate = new Editor(dbEditor);
            return new EditorDTO(editorRepository.save(editorToUpdate));
        } else {
            throw new NoSuchUserException(editorId);
        }
    }

    public EditorDTO saveEditor(Editor editor) {
        Editor editorCheck = this.editorRepository.findByEmail(editor.getEmail());
        if (editorCheck == null) {
            editor.setConfirmationToken(UUID.randomUUID().toString());
            System.out.println(editor.getEmail());
            editor.setSampleVideoList(null);
            editor.setCertifications(null);
            editor.setCommunicationLanguages(null);
            editor.setSocialMediaList(null);
            editor.setSkillList(null);
            EditorDTO editorDTO = new EditorDTO(editorRepository.save(editor));
//            this.emailSenderService.initiateEmail(editor.getConfirmationToken(),editor.getEmail(),false);
            System.out.println("Editor successful Registration");
            return editorDTO;
        }
        throw new UserAlreadyExistsException(editor.getEmail());

    }

    public List<EditorDTO> getAllEditors() {
        List<EditorDTO> editorDTOList = new ArrayList<>();
        List<Editor> editorList = editorRepository.findAll();
        if (!editorList.isEmpty()) {
            for (Editor editor : editorList) {
                editorDTOList.add(new EditorDTO(editor));
            }
            return editorDTOList;
        }

        return null;
    }

    public List<Editor> getAllEditors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
//        List<EditorDTO> editorDTOList = new ArrayList<>();
        List<Editor> editorList = editorRepository.findAllByPagination(pageable);
        if (!editorList.isEmpty()) {
            return editorList;
        }

        return null;
    }

    public EditorDTO getEditorById(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            return new EditorDTO(editor.get());
        }

        throw new NoSuchUserException(editorId);
    }

    public Editor getEditorByIdForMapping(Long editorId) {
        Optional<Editor> editor = editorRepository.findById(editorId);
        if (editor.isPresent()) {
            return editor.get();
        }

        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> searchEditorByName(String name) {
        List<EditorDTO> editorList = editorRepository.findEditorByName(name);
        if (!editorList.isEmpty()) {
            return editorList;
        }

        throw new NoSuchUserException();
    }

    public List<EditorDTO> filterEditorByAge(int minAge, int maxAge) {
        return editorRepository.filterByAge(minAge, maxAge);
    }

    public List<EditorDTO> filterEditorByCountry(String countryName) {
        return editorRepository.filterByCountry(countryName);
    }

    public List<EditorDTO> sortEditorsByExperience() {
        return editorRepository.sortEditorsByExperience();
    }

    public List<EditorDTO> getEditorsByGender(String gender) {
        return editorRepository.filterByGender(gender);
    }

    public Long countTotalEditors() {
        return editorRepository.countTotalNoOfEditor();
    }

    public EditorDTO getEditorByEmail(String email) {
        EditorDTO editor = editorRepository.getEditorByEmail(email);
        if (editor != null) {
            return editor;
        }

        throw new NoSuchUserException(email);
    }

    public List<EditorDTO> getEditorByExperienceRange(int minExperience, int maxExperience) {
        return editorRepository.filterByExperience(minExperience, maxExperience);
    }

    public EditorDTO isValidUser(String userEmail, String userPassword) {
        return editorRepository.isValidLogin(userEmail, userPassword);
    }

    public List<ProjectDTO> getProjectByEditorId(Long editorId) {
        List<Project> projectList = projectRepository.findByEditorId(editorId);
        if (!projectList.isEmpty()) {
            List<ProjectDTO> projectDTOList = new ArrayList<>();
            for (Project project : projectList) {
                projectDTOList.add(new ProjectDTO(project));
            }
            return projectDTOList;
        }

        throw new NoSuchUserException(editorId);
    }

    public List<EditorDTO> sortEditorsBy(String sortBy) {
        return editorRepository.sortEditorBy(sortBy);
    }

    public Editor verifyAccount(String confirmationToken) {
        Editor editor = this.editorRepository.findByConfirmationToken(confirmationToken);
        if (editor != null) {
            editor.setVerified(true);
            editor.setConfirmationToken(null);
            this.editorRepository.save(editor);
            System.out.println("heibfdsvbisuhv");
            return editor;
        } else {
            throw new NoSuchUserException();
        }
    }

    public Review addReview(Long editorId, Long creatorId, String reviewDescription) {
        Review dbReview = this.reviewRepository.findReviewByCreatorEditorId(creatorId, editorId);
        if (!(dbReview == null)) {
            dbReview.setReviewDescription(reviewDescription);
            return this.reviewRepository.save(dbReview);
        } else {
            Review review = new Review();
            review.setReviewDescription(reviewDescription);
            review.setEditorId(editorId);
            review.setCreatorId(creatorId);
            return this.reviewRepository.save(review);
        }
    }

    public List<Review> getEditorReviewList(Long editorId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.reviewRepository.findAllReviewByEditorId(editorId, pageable);
    }

    @Transactional
    public boolean deleteReview(Long creatorId, Long editorId) {
        Review dbReview = this.reviewRepository.findReviewByCreatorEditorId(creatorId, editorId);
        if (dbReview == null) {
            return false;
        } else {
            this.reviewRepository.deleteReviewByCreatorEditorId(creatorId, editorId);
            return true;
        }
    }

    public List<EditorSampleVideo> addMyVideo(Long editorId, List<EditorSampleVideo> editorSampleVideoList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getSampleVideoList().addAll(editorSampleVideoList);
//            editor.setSampleVideoList(editorSampleVideoList);
            this.editorRepository.save(editor);
            return editor.getSampleVideoList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorSampleVideo> getMyVideo(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {

            return editorDb.get().getSampleVideoList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorSocialMedia> addSocialMedia(Long editorId, List<EditorSocialMedia> editorSocialMediaList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getSocialMediaList().addAll(editorSocialMediaList);
            this.editorRepository.save(editor);
            return editor.getSocialMediaList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorSocialMedia> getSocialMedia(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            return editorDb.get().getSocialMediaList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorSkill> addSkill(Long editorId, List<EditorSkill> editorSkillList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getSkillList().addAll(editorSkillList);
            this.editorRepository.save(editor);
            return editor.getSkillList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorSkill> getSkills(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            return editorDb.get().getSkillList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorPreference> addPreference(Long editorId, List<EditorPreference> preferencesList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getPreferencesList().addAll(preferencesList);
            this.editorRepository.save(editor);
            return editor.getPreferencesList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorPreference> getPreference(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            return editorDb.get().getPreferencesList();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorCommunicationLanguage> addCommunication(Long editorId,
                                                              List<EditorCommunicationLanguage> editorCommunicationLanguageList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getCommunicationLanguages().addAll(editorCommunicationLanguageList);
            this.editorRepository.save(editor);
            return editor.getCommunicationLanguages();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorCommunicationLanguage> getCommunication(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            return editorDb.get().getCommunicationLanguages();
        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorCertification> addCertification(Long editorId, List<EditorCertification> editorCertificationList) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            Editor editor = editorDb.get();
            editor.getCertifications().addAll(editorCertificationList);
            this.editorRepository.save(editor);
            return editor.getCertifications();

        }else {
            throw new NoSuchUserException("User Not found");
        }
    }

    public List<EditorCertification> getCertification(Long editorId) {
        Optional<Editor> editorDb = this.editorRepository.findById(editorId);
        if(editorDb.isPresent())
        {
            return editorDb.get().getCertifications();
        }else {
            throw new NoSuchUserException("User Not found");
        }
    }
}
