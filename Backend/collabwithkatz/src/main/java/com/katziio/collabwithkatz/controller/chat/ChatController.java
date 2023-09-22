package com.katziio.collabwithkatz.controller.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chat")
@RestController
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/addChat")
    public ChatDTO addMessage(@RequestBody Chat chat)
    {
        return this.chatService.addMessage(chat);
    }

    @GetMapping("/getChat/{creatorId}/{editorId}")
    public List<ChatDTO> getMessage(@PathVariable Long creatorId, @PathVariable Long editorId)
    {
        return this.chatService.getMessage(creatorId,editorId);
    }




}
