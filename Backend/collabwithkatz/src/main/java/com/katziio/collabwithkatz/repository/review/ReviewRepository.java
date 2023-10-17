package com.katziio.collabwithkatz.repository.review;

import com.katziio.collabwithkatz.entity.common.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT r FROM Review r WHERE r.creatorId = :creatorId AND r.editorId = :editorId")
    Review findReviewByCreatorEditorId(@Param("creatorId") Long creatorId, @Param("editorId") Long editorId);

    @Query("SELECT r FROM Review r WHERE r.editorId = :editorId")
    List<Review> findAllReviewByEditorId(@Param("editorId") Long editorId);

    @Query("DELETE FROM Review r WHERE r.creatorId = :creatorId AND r.editorId = :editorId")
    void deleteReviewByCreatorEditorId(@Param("creatorId") Long creatorId, @Param("editorId") Long editorId);
}