package com.learn.langchain4j.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * LangChain4j 聊天服务示例
 * <p>
 * 演示 LangChain4j 的基础用法：
 * 1. 直接调用 ChatLanguageModel
 * 2. 使用 PromptTemplate 构建提示词
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    // 注入 ChatLanguageModel（通过 application.yml 配置 API Key 后自动装配）
    private final ChatLanguageModel chatLanguageModel;

    /**
     * 简单聊天：直接发送消息
     *
     * @param userMessage 用户输入
     * @return AI 回复
     */
    public String chat(String userMessage) {
        log.info("用户输入: {}", userMessage);
        String response = chatLanguageModel.generate(userMessage);
        log.info("AI 回复: {}", response);
        return response;
    }

    /**
     * 使用 PromptTemplate 构建提示词
     *
     * @param topic    话题
     * @param language 语言
     * @return AI 生成的内容
     */
    public String chatWithTemplate(String topic, String language) {
        PromptTemplate template = PromptTemplate.from(
                "请用{{language}}解释以下话题，要求简明扼要（100字以内）：\n\n话题：{{topic}}"
        );

        Prompt prompt = template.apply(Map.of(
                "topic", topic,
                "language", language
        ));

        log.info("构建的 Prompt: {}", prompt.text());
        return chatLanguageModel.generate(prompt.text());
    }
}
