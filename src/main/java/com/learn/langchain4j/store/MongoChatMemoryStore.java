package com.learn.langchain4j.store;

import com.learn.langchain4j.entity.ChatMemoryDocument;
import com.learn.langchain4j.repository.ChatMemoryRepository;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoChatMemoryStore implements ChatMemoryStore {

    private final ChatMemoryRepository chatMemoryRepository;

    public MongoChatMemoryStore(ChatMemoryRepository chatMemoryRepository) {
        this.chatMemoryRepository = chatMemoryRepository;
    }

    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        Integer memId = Integer.valueOf(memoryId.toString());
        ChatMemoryDocument document = chatMemoryRepository.findByMemoryId(memId).orElse(null);
        if (document == null || document.getMessage() == null) {
            return new ArrayList<>();
        }
        return ChatMessageDeserializer.messagesFromJson(document.getMessage());
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        String json = ChatMessageSerializer.messagesToJson(messages);
        Integer memId = Integer.valueOf(memoryId.toString());

        ChatMemoryDocument document = chatMemoryRepository.findByMemoryId(memId).orElse(null);
        if (document == null) {
            document = new ChatMemoryDocument();
            document.setMemoryId(memId);
            document.setCreateTime(new java.util.Date());
        }
        document.setMessage(json);
        document.setUpdateTime(new java.util.Date());

        chatMemoryRepository.save(document);
    }

    @Override
    public void deleteMessages(Object memoryId) {
        Integer memId = Integer.valueOf(memoryId.toString());
        chatMemoryRepository.deleteByMemoryId(memId);
    }
}
