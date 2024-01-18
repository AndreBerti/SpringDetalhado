package com.tekila.repository;

import org.springframework.stereotype.Repository;

import com.tekila.entity.Clientes;
/*Indica que será responsavel por ser o repositorio
 * ou seja quem vai fazer os movimentos com o banco de dados.*/
@Repository
public class ClientesRepository {

	public void save(Clientes cliente) {
		// salvando cliente acessando o banco de dados
	}

}
