package com.katziio.collabwithkatz.controller.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.service.chat.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/chat")
@RestController
@CrossOrigin("*")
public class ChatController {

    Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private ChatService chatService;

    @RequestMapping("/test")
    public String test() {
        this.logger.warn("This is working message");
        return "Testing message";
    }
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

    @GetMapping("/getCreatorList/{editorId}")
    public Map<Long, String> getCreatorNames(@PathVariable Long editorId)
    {
        return this.chatService.getCreatorName(editorId);
    }
}
