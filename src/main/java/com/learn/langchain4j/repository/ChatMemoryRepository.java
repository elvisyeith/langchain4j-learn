package com.learn.langchain4j.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learn.langchain4j.entity.ChatMemoryDocument;

import java.util.Optional;

@Repository
public interface ChatMemoryRepository extends MongoRepository<ChatMemoryDocument, String> {
    Optional<ChatMemoryDocument> findByMemoryId(Integer memoryId);

    void deleteByMemoryId(Integer memoryId);
}
