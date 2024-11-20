package com.bruce.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx = app.run(args);

		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.tellStory());
		System.out.println(firstService.getCustomProperty());
		System.out.println(firstService.getCustomPropertyInt());
		System.out.println(firstService.getCustomPropertyFromAnotherFile());
	}
}
