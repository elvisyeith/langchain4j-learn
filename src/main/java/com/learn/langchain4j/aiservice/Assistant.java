package com.learn.langchain4j.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "openAiChatModel", chatMemoryProvider = "chatMemoryProvider")
public interface Assistant {
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
