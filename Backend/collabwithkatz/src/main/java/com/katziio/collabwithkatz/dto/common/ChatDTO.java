package com.katziio.collabwithkatz.dto.common;

import com.katziio.collabwithkatz.entity.common.Chat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatDTO  {
    private Long Id;
    private Long creatorId;
    private Long editorId;
    private String creatorMessage;
    private String editorMessage;

    public ChatDTO(Chat chat)
    {
        this.Id=chat.getId();
        this.creatorId=chat.getCreatorId();
        this.editorId= chat.getEditorId();;
        this.editorMessage=chat.getEditorMessage();
        this.creatorMessage = chat.getCreatorMessage();
    }
}