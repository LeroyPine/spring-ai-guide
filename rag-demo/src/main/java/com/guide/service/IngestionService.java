package com.guide.service;

import com.guide.loader.DocumentLoader;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngestionService {

    private final DocumentLoader loader;
    private final VectorStore vectorStore;

    @PostConstruct
    public void ingest() throws IOException {
        // 放入你想让ai理解的知识库
        String path = "docs/AI编程效率指南.txt";
        List<Document> documents = loader.load(path);
        vectorStore.add(documents);
        System.out.println("成功加载 " + documents.size() + " 个文档块到向量库！");
    }
}