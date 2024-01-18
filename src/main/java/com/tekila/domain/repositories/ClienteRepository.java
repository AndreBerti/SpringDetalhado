package com.tekila.domain.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tekila.domain.entity.Cliente;

@Repository
public class ClienteRepository {
	
	private static String INSERT = "insert into cliente (nome) values (?)";
	private static String SELECT_ALL = "select * from cliente";
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	
	/*comando update para atualizar passa-se o comando sql e a complementação do generic*/
	public Cliente salvar(Cliente cliente) {
		jdbcTemplete.update(INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	
	/*jdbcTemplete.query com o comando SQL descrito acima, e o rowmapper vai mapear o banco de dados, e vai retortar o resultSet
	 * com o nome e id de cada cliente.*/
	public List<Cliente> obterTodos(){
		return jdbcTemplete.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException{
				Integer id = resultSet.getInt("id");
				String nome=resultSet.getString("nome");
				return new Cliente(id,nome);	
			}
		});
				
	}
}
