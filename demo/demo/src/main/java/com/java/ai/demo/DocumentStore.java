package com.java.ai.demo;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DocumentStore {

    private final Map<String, String> docs = new HashMap<>();
    ClassLoader classLoader = DocumentStore.class.getClassLoader();
    URL resource = classLoader.getResource("docs/patanjali_yoga_sutras_article.txt");

        public void add(String id, String content) {
            docs.put(id, content);
        }

        public String search(String query) {
            // Simplified match for demo; in real use, embed + similarity search
            return docs.values().stream()
                    .filter(text -> text.toLowerCase().contains(query.toLowerCase()))
                    .findFirst().orElse("No relevant context found.");
        }

        public void loadDocStore() throws URISyntaxException, IOException {
            File file = new File(resource.toURI());
            String content = FileUtils.readFileToString(file, "UTF-8");
            String[] str = content.split("[\r\n]+");
            AtomicInteger i= new AtomicInteger();
            Arrays.stream(str).forEach(s -> add(String.valueOf(i.incrementAndGet()), s));
            System.out.println(content);
        }

}
