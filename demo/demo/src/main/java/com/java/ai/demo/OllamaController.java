/*
package com.java.ai.demo;

import dev.langchain4j.model.ollama.OllamaChatModel;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OllamaController {

    private final OllamaChatModel aimodel;
    public OllamaController(){
        this.aimodel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("mistral")
                .build();
    }



    public ResponseEntity<String> getResults(@PathVariable String userPrompt){
aimodel.
        return ResponseEntity.ok("Hello World");
    }
}
*/
