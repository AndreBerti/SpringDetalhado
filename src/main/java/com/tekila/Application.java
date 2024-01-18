package com.tekila;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			Cliente cliente= new Cliente();
			cliente.setNome("Tekila");
			clienteRepository.salvar(cliente);
			Cliente cliente1= new Cliente();
			cliente1.setNome("André");
			clienteRepository.salvar(cliente1);
			Cliente cliente2= new Cliente();
			cliente2.setNome("Vanessa");
			clienteRepository.salvar(cliente2);
			Cliente cliente3= new Cliente();
			cliente3.setNome("Godofrego");
			clienteRepository.salvar(cliente3);
			
			List<Cliente> todosClientes = clienteRepository.obterTodos();
			for(Cliente x:todosClientes) {
				System.out.println(x);
			}
		};
	}
	
	

}
