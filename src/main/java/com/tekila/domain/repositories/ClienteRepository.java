package com.tekila.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tekila.domain.entity.Cliente;


/* tornando interface e estendendo da JpaRepository do org.Spring todas as funcionalidades padrão de um repositorio ja vem incluido
 * a extensão vem da seguinte forma JpaRepository<T, ID>, onde T é o tipo do objeto e id é a chave primaria*/
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

		
	/*
	 * Existe dentro do pacote um padrão ja de comandos SQL pelo JpaRepository
	 * Exemplo, tem o FindByAll, mas se eu quiser pesquisar por outro atributo da classe Cliente, por exemplo Nome
	 * ele vai entender que vai ser o FindByNOME_DO_ATRIBUTO, que você deseja procurar
	 * */
	List<Cliente> findByNomeLike(String nome);
	
	/*
	 * Da mesma forma, você pode criar sua Query, caso os padrões não sejam suficientes.
	 * Não é necessario usar o comando JPQL, é possivel usar os comandos SQL
	 * basta informar tambem que usará uma query nativa do sql, nativeQuery=true
	 * */
	
	@Query(value="Select * from tb_cliente c where c.nome like '%nome%' ",nativeQuery = true)
	List<Cliente> encontrarPorNome(@Param("nome") String nome);
		
	/*
	 * O parametro Exists verifica se existe e retorna um boolean
	 * */
	boolean existsByNome(String nome);
}
