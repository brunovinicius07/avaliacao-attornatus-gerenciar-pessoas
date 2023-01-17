package com.attornatus.gerenciarpessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GerenciarPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarPessoasApplication.class, args);
	}
}
