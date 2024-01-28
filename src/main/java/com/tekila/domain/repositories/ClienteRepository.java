package com.tekila.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekila.domain.entity.Cliente;


/* tornando interface e estendendo da JpaRepository do org.Spring todas as funcionalidades padrão de um repositorio ja vem incluido
 * a extensão vem da seguinte forma JpaRepository<T, ID>, onde T é o tipo do objeto e id é a chave primaria*/
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByNomeLike(String nome);
	
}
