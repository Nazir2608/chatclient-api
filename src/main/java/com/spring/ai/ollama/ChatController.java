package com.spring.ai.ollama;

import com.spring.ai.ollama.entity.Tut;
import com.spring.ai.ollama.service.ChatServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

  private  final ChatServiceImpl chatService;

    public ChatController(ChatServiceImpl chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ollama")
    public ResponseEntity<List<Tut>> ollama(@RequestParam String q) {
        return ResponseEntity.ok(chatService.chat(q));
    }

}