package com.example.newClientWebservice;

import com.example.newClientWebservice.Service.ArticleService;
import com.example.newClientWebservice.Service.CartService;
import com.example.newClientWebservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.newClientWebservice.Service.UserService.login;

@SpringBootApplication
public class NewClientWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewClientWebserviceApplication.class, args);
	}


}
