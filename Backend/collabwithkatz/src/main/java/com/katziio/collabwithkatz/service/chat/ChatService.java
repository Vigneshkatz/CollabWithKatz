package com.katziio.collabwithkatz.service.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.dto.creator.CreatorDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.repository.chat.ChatRepository;
import com.katziio.collabwithkatz.repository.creator.CreatorRepository;
import com.katziio.collabwithkatz.service.creator.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private CreatorService creatorService;
    public ChatDTO addMessage(Chat chat) {
        this.chatRepository.save(chat);
        return new ChatDTO(chat);
    }

    public List<ChatDTO> getMessage(Long creatorId,Long editorId) {
       return this.chatRepository.findByCreatorIdAndEditorId(creatorId,editorId);
    }

    public Set<String> getCreatorName(Long editorId) {
        Set<String> creatorNameList = new HashSet<>();
        List<ChatDTO> chatList = this.chatRepository.findByEditorId(editorId);
        for(ChatDTO chat : chatList)
        {
            Long creatorId = chat.getCreatorId();
            CreatorDTO creator = this.creatorService.getCreatorById(creatorId);
            creatorNameList.add(creator.getName());
        }
        return creatorNameList;
    }
}
