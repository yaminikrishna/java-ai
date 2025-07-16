package com.java.ai.demo;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.stereotype.Component;

@Component
public class RAGService {

    private final OllamaChatModel model;

    public RAGService() {
        model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("tinyllama")
                .build();
    }

    public String ask(String question, String context) {
        String prompt = String.format("Answer the question based on the context below:\n\nContext: %s\n\nQuestion: %s", context, question);
        return model.generate(prompt);
    }
}
