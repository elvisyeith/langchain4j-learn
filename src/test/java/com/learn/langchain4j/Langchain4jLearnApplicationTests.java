package com.learn.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;

class Langchain4jLearnApplicationTests {

    @Test
    public void helloWorld() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini").build();
        String answer = model.generate("你是谁");
        System.out.println(answer);
    }
}
