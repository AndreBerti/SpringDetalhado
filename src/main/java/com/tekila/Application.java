package com.tekila;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.tekila.domain.entity.Cliente;
import com.tekila.domain.repositories.ClienteRepository;
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
		return args-> {
			clienteRepository.save(new Cliente("Tekila"));
			clienteRepository.save(new Cliente("André"));
			clienteRepository.save(new Cliente("Vanessa"));
			clienteRepository.save(new Cliente("Osvaldo"));
			clienteRepository.save(new Cliente("Valdo"));
			clienteRepository.save(new Cliente("Iago"));
			clienteRepository.save(new Cliente("Yago"));
			clienteRepository.save(new Cliente("vou excluir"));
			List<Cliente> todosClientes = clienteRepository.findAll();
			for(Cliente x:todosClientes) {
				System.out.println(x);
			}
			
			
			for(Cliente x:todosClientes) {
				if(x.getNome().equals("vou excluir"))
					clienteRepository.delete(x);
			}
			
			String nomeVelho="Valdo";
			String nomeNovo="Jorginho";
			
			for(Cliente x:todosClientes) {
				
			}
			
			todosClientes=clienteRepository.encontrarPorNome("%ago%");
			for(Cliente x:todosClientes) {
				System.out.println(x);
			}
			
			
		};
	}
	
	

}
