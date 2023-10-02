package com.katziio.collabwithkatz.entity.common;

import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.editor.Editor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;
    private String creatorMessage;
    private String editorMessage;
}
