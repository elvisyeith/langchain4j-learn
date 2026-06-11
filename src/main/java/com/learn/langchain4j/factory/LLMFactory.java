package com.learn.langchain4j.factory;

import com.learn.langchain4j.factory.service.LLMService;
import org.springframework.stereotype.Component;

@Component
public class LLMFactory {

    public enum ModelType {
        OPENAI
    }

    private final LLMService openaiLLMService;

    // Spring will automatically inject the OpenaiLLMService bean
    public LLMFactory(LLMService openaiLLMService) {
        this.openaiLLMService = openaiLLMService;
    }

    public LLMService getModel(ModelType modelType) {
        switch (modelType) {
            case OPENAI:
                return openaiLLMService;
            default:
                throw new IllegalArgumentException("Unknown model type: " + modelType);
        }
    }
}
