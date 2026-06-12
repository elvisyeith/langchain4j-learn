package com.learn.langchain4j.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "openAiChatModel", streamingChatModel = "openaiStreamingChatModel", chatMemoryProvider = "chatMemoryProvider", tools = "testTools")
public interface AiAssistant {
    String chat(@MemoryId String id, @UserMessage String message);

    Flux<String> chatStream(@MemoryId String id, @UserMessage String message);
}
