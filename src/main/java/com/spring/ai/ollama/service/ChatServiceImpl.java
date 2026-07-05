package com.spring.ai.ollama.service;

import com.spring.ai.ollama.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }



    @Override
    public List<Tut> chat(String query) {
        Prompt prompt1 = new Prompt(query);
        return chatClient.prompt(prompt1).call().entity(new ParameterizedTypeReference<List<Tut>>() {
        });

        //return chatClient.prompt(prompt1).call().chatResponse().getResult().getOutput().getText();
       // return chatClient.prompt().user(prompt).system("Behave as expert in cricket").call().content();
    }
}
