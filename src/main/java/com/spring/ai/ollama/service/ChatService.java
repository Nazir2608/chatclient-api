package com.spring.ai.ollama.service;

import com.spring.ai.ollama.entity.Tut;

import java.util.List;

public interface ChatService {

    public List<Tut> chat(String query);
}
