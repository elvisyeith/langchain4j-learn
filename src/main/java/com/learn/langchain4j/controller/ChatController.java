package com.learn.langchain4j.controller;

import com.learn.langchain4j.model.ApiResult;
import com.learn.langchain4j.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * LangChain4j 聊天接口
 */
@Tag(name = "01. 基础聊天", description = "LangChain4j ChatLanguageModel 基础用法示例")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @Operation(summary = "简单聊天", description = "直接向 AI 发送一条消息并获取回复")
    @PostMapping("/simple")
    public ApiResult<String> simpleChat(
            @Parameter(description = "用户输入的消息", required = true)
            @RequestParam String message) {
        String response = chatService.chat(message);
        return ApiResult.success(response);
    }

    @Operation(summary = "模板聊天", description = "使用 PromptTemplate 构建提示词，演示模板变量替换")
    @GetMapping("/template")
    public ApiResult<String> templateChat(
            @Parameter(description = "话题", example = "机器学习") @RequestParam String topic,
            @Parameter(description = "回答语言", example = "中文") @RequestParam(defaultValue = "中文") String language) {
        String response = chatService.chatWithTemplate(topic, language);
        return ApiResult.success(response);
    }
}
