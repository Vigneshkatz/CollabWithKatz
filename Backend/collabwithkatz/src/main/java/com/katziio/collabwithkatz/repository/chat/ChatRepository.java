package com.katziio.collabwithkatz.repository.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Long> {

    @Query("SELECT new com.katziio.collabwithkatz.dto.common.ChatDTO(c) FROM Chat c WHERE c.creatorId = :creatorId and c.editorId = :editorId")
    List<ChatDTO>findByCreatorIdAndEditorId(@Param("creatorId") Long creatorId, @Param("editorId") Long editorId);

    @Query("SELECT new com.katziio.collabwithkatz.dto.common.ChatDTO(c) FROM Chat c WHERE c.editorId = :editorId")
    List<ChatDTO>findByEditorId( @Param("editorId") Long editorId);
}
