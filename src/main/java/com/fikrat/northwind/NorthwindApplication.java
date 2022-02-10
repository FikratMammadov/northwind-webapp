package com.fikrat.northwind;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("public-apis")
				.pathsToMatch("/**")
				.pathsToExclude("/actuator/**")
				.build();
	}

//	@Bean
//	public GroupedOpenApi actuatorApi() {
//		return GroupedOpenApi.builder()
//				.group("actuators")
//				.pathsToMatch("/actuators/**")
//				.build();
//	}

}


