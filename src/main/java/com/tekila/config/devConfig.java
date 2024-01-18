package com.tekila.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.tekila.annotation.Development;


/*
 * agora basta botar apenas o @development que foi criado
 * */
@Development
public class devConfig {
	@Bean
	public CommandLineRunner executar() {
		return args->{
			System.out.println("rodando propiedades de Desenvolvimento");
		};
	}
}
