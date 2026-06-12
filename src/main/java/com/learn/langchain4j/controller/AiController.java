package com.learn.langchain4j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.langchain4j.aiservice.AiAssistant;

@RestController()
@RequestMapping("/ai")
public class AiController {

    private final AiAssistant aiAssistant;

    public AiController(AiAssistant aiAssistant) {
        this.aiAssistant = aiAssistant;
    }
}

