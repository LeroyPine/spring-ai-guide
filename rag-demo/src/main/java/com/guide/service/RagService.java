package com.guide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * RAG 服务类
 * 实现基于检索增强生成（RAG）的问答功能
 * 
 * @author guide
 */
@Service
@RequiredArgsConstructor
public class RagService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    /**
     * 流式回答
     * 通过向量存储检索相关文档，并结合 AI 模型生成回答
     * 
     * @param question 用户提问
     * @return Flux<String> 流式响应结果
     */
    public Flux<String> askStream(String question) {
        return chatClient.prompt()
                .user(question)
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .stream()
                .content();  // 获取 Flux<String> 流
    }

    /**
     * 同步回答
     * 通过向量存储检索相关文档，并结合 AI 模型生成回答
     * 注意：此方法为阻塞式调用，在高并发场景下需谨慎使用
     * 
     * @param question 用户提问
     * @return String 回答内容
     */
    public String ask(String question) {
        return chatClient.prompt()
                .user(question)
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .call()
                .content();  // 同步获取字符串内容
    }
}