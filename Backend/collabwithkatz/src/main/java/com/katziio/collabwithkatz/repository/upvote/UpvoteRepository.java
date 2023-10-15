package com.katziio.collabwithkatz.repository.upvote;

import com.katziio.collabwithkatz.entity.common.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UpvoteRepository extends JpaRepository<Upvote,Long> {

    @Query("SELECT * FROM Upvote u WHERE u.creatorId= :creatorId AND u.editorId= : editorId")
    Upvote findByCreatorIdEditorId(@Param("creatorId") Long creatorId, @Param("editorId") Long editorId);

    @Query("SELECT count(*) FROM Upvote u WHERE u.editorId= : editorId")
    Long countUpvoteByEditorId(@Param("editorId") Long editorId);
}
