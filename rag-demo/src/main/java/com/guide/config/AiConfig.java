package com.guide.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AI 配置类
 * 用于配置向量存储和聊天客户端等核心组件
 * 
 * @author guide
 */
@Configuration
public class AiConfig {

    /**
     * 配置向量存储 Bean
     * 使用 SimpleVectorStore 实现，用于存储和检索文档向量
     * 
     * @param embeddingModel 嵌入模型，用于将文本转换为向量
     * @return VectorStore 向量存储实例
     */
    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel) {
        return SimpleVectorStore.builder(embeddingModel)
                .build();
    }

    /**
     * 配置聊天客户端 Bean
     * 用于与 AI 模型进行对话交互
     * 
     * @param chatModel 聊天模型
     * @return ChatClient 聊天客户端实例
     */
    @Bean
    public ChatClient chatClient(ChatModel chatModel) {
        return ChatClient.builder(chatModel).build();

    }
}
