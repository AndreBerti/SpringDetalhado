package com.tekila.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity diz que é uma entidade, e vai criar no banco de dados um campo com o mesmo nome da classe
 * se quiser alterar o nome do campo, basta usar o @Table(name="Nome da tabela")*/
@Entity
@Table(name="tb_Cliente")
public class Cliente {
	
	/*o @id é fundamental para o mapeamento do objeto pois é a primaryKey
	 * é importante também indicar a estrategia de criação da chave primaria, como o auto_increment no sql*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/*no @Column da a possibilidade de definir propriedades da coluna
	 * obs: não é obrigatorio*/
	@Column (name="nome", length = 30)
	private String nome;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	public Cliente(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

	
	
	
}
