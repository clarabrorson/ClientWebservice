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

	@Bean
	CommandLineRunner run() {
		return args -> {
			//ArticleService.getAllArticles();
			//CartService.getOneCartById(1, login().getJwt()); //Fungerar
			//CartService.getAllCarts(login().getJwt()); //Fungerar
			CartService.addArticleToCart(1, 1, login().getJwt()); //Fungerar
			//CartService.updateArticleCount(1, 1, 5, login().getJwt()); //Fungerar
			//CartService.deleteArticleFromCart(1, 1, login().getJwt()); //Fungerar
		};
	}

}
