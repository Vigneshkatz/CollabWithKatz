package com.katziio.collabwithkatz.repository.upvote;

import com.katziio.collabwithkatz.entity.common.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote,Long> {

    @Query("SELECT u FROM Upvote u WHERE u.creatorId= :creatorId AND u.editorId= :editorId")
    Upvote findByCreatorIdEditorId(@Param("editorId")Long editorId,@Param("creatorId")  Long creatorId);

    @Query("SELECT count(u) FROM Upvote u WHERE u.editorId= :editorId AND u.isVoted = true")
    Long countUpvoteByEditorId(@Param("editorId") Long editorId);
}
