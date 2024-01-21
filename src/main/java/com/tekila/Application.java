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
			clienteRepository.salvar(new Cliente("Tekila"));
			clienteRepository.salvar(new Cliente("André"));
			clienteRepository.salvar(new Cliente("Vanessa"));
			clienteRepository.salvar(new Cliente("Osvaldo"));
			clienteRepository.salvar(new Cliente("Valdo"));
			clienteRepository.salvar(new Cliente("Iago"));
			clienteRepository.salvar(new Cliente("Yago"));
			clienteRepository.salvar(new Cliente("vou excluir"));
			List<Cliente> todosClientes = clienteRepository.obterTodos();
			for(Cliente x:todosClientes) {
				System.out.println(x);
			}
			
			
			clienteRepository.deletar(8);
			String nomeVelho="Valdo";
			String nomeNovo="Jorginho";
			
			for(Cliente x:todosClientes) {
				if(x.getNome().toUpperCase().equals(nomeVelho.toUpperCase())) {
					x.setNome(nomeNovo);
					clienteRepository.atualizar(x);
				}
			}
			
			todosClientes=clienteRepository.buscarNome("ago");
			for(Cliente x:todosClientes) {
				System.out.println(x);
			}
			
			
		};
	}
	
	

}
