package com.tekila.domain.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tekila.domain.entity.Cliente;

@Repository
public class ClienteRepository {
	
	@Autowired
	EntityManager entityManager;
	
	/*Importante, se for fazer movimento no banco de dados, é importante usar @Transactional, do org.spring, senão vai dar erro*/
	@Transactional
	public void salvar(Cliente cliente) {
		entityManager.persist(cliente);
	}
}
