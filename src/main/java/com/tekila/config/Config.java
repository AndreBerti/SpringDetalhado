package com.tekila.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*@Configuration indica que é responsavel pela configuração do sistema*/
@Configuration
public class Config {
	/*@Bean serve para fazer injeção de dependencias
	 * agora ele vai reconhecer o metodo applicationName em qualquer lugar.*/
	@Bean
	public String applicationName() {
		return "Sistema de Vendas";
	}
}
