package com.learn.langchain4j.factory.service;

import org.springframework.stereotype.Service;
import dev.langchain4j.model.chat.ChatLanguageModel;

@Service
public class OpenaiLLMService implements LLMService {

    private final ChatLanguageModel openAiChatModel;

    // Spring will automatically inject the ChatLanguageModel configured in application.yml
    public OpenaiLLMService(ChatLanguageModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public String chat(String prompt) {
        return openAiChatModel.generate(prompt);
    }
}
