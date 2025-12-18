package com.guide.loader;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文档加载器
 * 用于加载和解析各种格式的文档文件
 * 
 * @author guide
 */
@Component
public class DocumentLoader {
    
    /**
     * 加载文档
     * 使用 TikaDocumentReader 解析文档内容
     * 
     * @param resourcePath 文档资源路径
     * @return List<Document> 解析后的文档列表
     */
    public List<Document> load(String resourcePath) {
        TikaDocumentReader reader = new TikaDocumentReader(resourcePath);
        return reader.read();
    }
}
