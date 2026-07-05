package com.spring.ai.ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultAdvisors()
                .defaultSystem("you are helpful coding assistant..")
                .defaultOptions(OllamaChatOptions
                        .builder()
                        .model("llava:latest")
                        .temperature(0.3)
                        .maxTokens(500)).build();
    }
}
