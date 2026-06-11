package com.learn.langchain4j.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j / OpenAPI 3 配置
 * Swagger UI 访问地址: http://localhost:8080/doc.html
 */
@Configuration
public class Knife4jConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("LangChain4j 学习项目 API")
                                                .description("Spring Boot + LangChain4j 学习示例接口文档")
                                                .version("v1.0.0")
                                                .contact(new Contact()
                                                                .name("Learn")
                                                                .email("learn@example.com"))
                                                .license(new License()
                                                                .name("Apache 2.0")
                                                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
        }
}