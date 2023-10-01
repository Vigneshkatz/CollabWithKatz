package com.katziio.collabwithkatz.dto.common;

import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.editor.Editor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChatDTO  {
    private Long Id;
    private Creator creator;
    private Editor editor;
    private String creatorMessage;
    private String editorMessage;

    public ChatDTO(Chat chat)
    {
        this.Id=chat.getId();
        this.creator=chat.getCreator();
        this.editor= chat.getEditor();;
        this.editorMessage=chat.getEditorMessage();
        this.creatorMessage = chat.getCreatorMessage();
    }
}