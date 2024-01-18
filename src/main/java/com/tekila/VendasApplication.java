package com.tekila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * @SpringBootApplication, é a primeira anotation, ela indica que sua aplicação Spring começa aqui
 * 
 * @Controller indica que aqui será o controlador.
 */
@SpringBootApplication
@RestController
public class VendasApplication {
	
	@Autowired
	@Qualifier("applicationName")
	private String applicationName;
	
	
	/*Pega o valor chave application.name no arquivo application.properties*/
    @Value("${application.name}")
    private String meuNome;
	
	/*@GetMapping mostra o caminho da url a ser usada*/
	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
	@GetMapping("/meuNome")
    public String meuNome() {
    	return meuNome;
    }
    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class,args);

    }
    
}
