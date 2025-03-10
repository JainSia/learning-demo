package com.ey.ms.learning_concept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class LearningConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningConceptApplication.class, args);
	}

}
