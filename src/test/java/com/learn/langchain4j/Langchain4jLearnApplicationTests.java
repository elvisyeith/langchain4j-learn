package com.learn.langchain4j;

import com.learn.langchain4j.aiservice.Assistant;
import com.learn.langchain4j.factory.LLMFactory;
import com.learn.langchain4j.factory.service.LLMService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4jLearnApplicationTests {

    @Autowired
    private LLMFactory llmFactory;

    @Test
    public void helloWorld() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini").build();
        String answer = model.generate("你是谁");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void chatMemory() {
        String answer = assistant.chat(1, "I am Elvis");
        System.out.println(answer);
        String answer2 = assistant.chat(1, "Do you know who am I?");
        System.out.println(answer2);
        String answer3 = assistant.chat(2, "How old am I?");
        System.out.println(answer3);
    }
}
