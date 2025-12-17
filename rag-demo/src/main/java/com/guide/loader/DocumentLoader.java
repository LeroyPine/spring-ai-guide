package com.guide.loader;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentLoader {
    public List<Document> load(String resourcePath) {
        TikaDocumentReader reader = new TikaDocumentReader(resourcePath);
        return reader.read();
    }
}
