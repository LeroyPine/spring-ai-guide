package com.guide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RagService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    // 流式回答（返回 Flux<String> 流）
    public Flux<String> askStream(String question) {
        return chatClient.prompt()
                .user(question)
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .stream()
                .content();  // 获取 Flux<String> 流
    }

    // 如果你想要同步（阻塞）返回 String，可以加这个方法（多线程场景慎用）
    public String ask(String question) {
        return chatClient.prompt()
                .user(question)
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .call()
                .content();  // 同步获取字符串内容
    }
}