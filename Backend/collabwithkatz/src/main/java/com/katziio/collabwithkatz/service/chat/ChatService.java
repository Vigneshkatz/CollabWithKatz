package com.katziio.collabwithkatz.service.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.repository.chat.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    public ChatDTO addMessage(Chat chat) {
        this.chatRepository.save(chat);
        return new ChatDTO(chat);
    }

    public List<ChatDTO> getMessage(Long creatorId,Long editorId) {
       return this.chatRepository.findByCreatorIdAndEditorId(creatorId,editorId);
    }
}
