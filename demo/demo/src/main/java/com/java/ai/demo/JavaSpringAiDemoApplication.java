package com.java.ai.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class JavaSpringAiDemoApplication {

	public static void main(String[] args) throws URISyntaxException, IOException {
	SpringApplication.run(JavaSpringAiDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(DocumentStore documentStore, RAGService ragService) {
		return args -> {
			documentStore.loadDocStore();
			String query = "Tell me about yoga";
			String context = documentStore.search(query);
			if (context == null || context.isBlank()) {
				System.out.println("Please ask about Yoga, Pranayama, or related topics only.");
			}
			String answer = ragService.ask(query, context);
			System.out.println("Q: " + query);
			System.out.println("A: " + answer);
		};
	}




}
