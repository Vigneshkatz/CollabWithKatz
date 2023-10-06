package com.katziio.collabwithkatz.controller.chat;

import com.katziio.collabwithkatz.dto.common.ChatDTO;
import com.katziio.collabwithkatz.entity.common.Chat;
import com.katziio.collabwithkatz.service.chat.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/v1/chat")
@RestController
@CrossOrigin("*")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/addMessage")
    public ResponseEntity<ChatDTO> addMessage(@RequestBody Chat chat, @RequestParam Long creatorId, @RequestParam Long editorId) {
        ChatDTO chatDTO = this.chatService.addMessage(chat, creatorId, editorId);
        return ResponseEntity.ok(chatDTO);
    }

    @GetMapping("/getMessages/{creatorId}/{editorId}")
    public ResponseEntity<List<ChatDTO>> getMessages(@PathVariable Long creatorId, @PathVariable Long editorId) {
        List<ChatDTO> chatMessages = this.chatService.getMessages(creatorId, editorId);
        return ResponseEntity.ok(chatMessages);
    }

    @GetMapping("/getCreators/{editorId}")
    public ResponseEntity<Map<Long, String>> getCreators(@PathVariable Long editorId) {
        Map<Long, String> creatorNames = this.chatService.getCreatorNames(editorId);
        return ResponseEntity.ok(creatorNames);
    }
}
