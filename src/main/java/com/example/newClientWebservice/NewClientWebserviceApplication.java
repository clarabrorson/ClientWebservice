package com.example.newClientWebservice;

import com.example.newClientWebservice.Service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewClientWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewClientWebserviceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run() {
		return args -> {
			ArticleService.getAllArticles();
		};
	}*/

}
