package com.spring.ai.ollama.service;
import com.spring.ai.ollama.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import java.util.Collections;
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
        //modify this prompt to add extra things to prompt to make that interactive
        String systemQuery="As an expert in coding and programming. Always write program in java. Now reply for this questions:{query}";

        String result = chatClient.prompt()
                .user(u -> u.text(systemQuery).param("query", query))
                .call()
                .content();

        System.out.println(result);
        return Collections.emptyList();
        //        return chatClient.prompt(prompt1).call().entity(new ParameterizedTypeReference<List<Tut>>() {
//        });

        //return chatClient.prompt(prompt1).call().chatResponse().getResult().getOutput().getText();
       // return chatClient.prompt().user(prompt).system("Behave as expert in cricket").call().content();
    }
}
