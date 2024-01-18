package com.tekila.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/*
 * @profile vai dizer qual a application.properties vai ser usada
 * */
@Configuration
@Profile("development")
public class devConfig {
	@Bean
	public CommandLineRunner executar() {
		return args->{
			System.out.println("rodando propiedades de Desenvolvimento");
		};
	}
}
