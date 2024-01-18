package com.tekila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekila.entity.Clientes;
import com.tekila.repository.ClientesRepository;

/*Indica que aqui serão os serviços
 * aqui que será feita adição e remoção de elementos
 * ligação direta com o @Repository*/
@Service
public class ClientesServices {
	
	private ClientesRepository clientesRepository;

	public ClientesServices(ClientesRepository clientesRepository) {
		this.clientesRepository=clientesRepository;
	}
	
	public void salvarCliente(Clientes cliente) {
		validarCliente(cliente);
		clientesRepository.save(cliente);
	}
	
	public void validarCliente(Clientes cliente) {
		// função de validaçao
	}
}
