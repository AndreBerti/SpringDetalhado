package com.tekila.domain.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	@Transactional
	public void atualizar(Cliente cliente) {
		entityManager.merge(cliente);
	}
	
	@Transactional
	public void deletar(Integer id) {
		Cliente cliente = entityManager.find(Cliente.class,id);
		entityManager.remove(cliente);	
	}
	@Transactional
	public void deletar(Cliente cliente) {
		deletar(cliente.getId()); 	
	}
	
	/*readOnly diz que vai apenas ler*/
	@Transactional(readOnly = true)
	public List<Cliente> buscarNome(String nome){
		/*uma consulta jpql - parecida com sql, so que referenciando as entidades ao inves da tabela*/
		String jpql = " select c from Cliente c where c.nome like :nome";
		
		TypedQuery<Cliente> query = entityManager.createQuery(jpql,Cliente.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	@Transactional
	public List<Cliente> obterTodos(){
		return entityManager
				.createQuery("from Cliente",Cliente.class)
				.getResultList();
	}
		
}
