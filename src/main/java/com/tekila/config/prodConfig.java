package com.tekila.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
@Profile("production")
public class prodConfig {
	@Bean
	public CommandLineRunner executar() {
		return args->{
			System.out.println("rodando propiedades de producao");
		};
	}
}
