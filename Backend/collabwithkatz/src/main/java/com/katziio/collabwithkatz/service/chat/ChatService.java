package com.katziio.collabwithkatz.service.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.entity.creator.Creator;
import com.katziio.collabwithkatz.entity.editor.Editor;
import com.katziio.collabwithkatz.exception.NoChatFoundException;
import com.katziio.collabwithkatz.repository.chat.ChatRepository;
import com.katziio.collabwithkatz.service.creator.CreatorService;
import com.katziio.collabwithkatz.service.editor.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private EditorService editorService;
    @Autowired
    private CreatorService creatorService;

    public ChatDTO addMessage(Chat chat, Long creatorId, Long editorId) {
        Creator creator = this.creatorService.getCreatorByIdForMapping(creatorId);
        Editor editor = this.editorService.getEditorByIdForMapping(editorId);
        chat.setCreator(creator);
        chat.setEditor(editor);

        this.chatRepository.save(chat);
        return new ChatDTO(chat);
    }

    public List<ChatDTO> getMessages(Long creatorId, Long editorId) {
        List<ChatDTO> chatList = this.chatRepository.findByCreatorIdAndEditorId(creatorId, editorId);
        if (!chatList.isEmpty()) {
            return this.chatRepository.findByCreatorIdAndEditorId(creatorId, editorId);
        }
        throw new NoChatFoundException();
    }

    public Map<Long, String> getCreatorNames(Long editorId) {
        // Replace this with actual logic to get creator names based on the editor
//        Map<Long, String> creatorIdName = new HashMap<>();
//        creatorIdName.put(1L, "Vignesh");
//        creatorIdName.put(2L, "Katziio");
//        creatorIdName.put(3L, "Teebikaa");
        Map<Long,String> creatorList = this.creatorService.getAllCreatorName(editorId);
        return creatorList;
    }
}
