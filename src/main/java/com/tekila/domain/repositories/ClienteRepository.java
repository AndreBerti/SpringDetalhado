package com.tekila.domain.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tekila.domain.entity.Cliente;

@Repository
public class ClienteRepository {

	private static String INSERT = "insert into cliente (nome) values (?)";
	private static String SELECT_ALL = "select * from cliente";
	private static String UPDATE = "update cliente set nome = ? where id=?";
	private static String DELETE = "delete from cliente where id = ? ";
	private static String BUSCA_NOME = "select * from cliente where nome like ?";

	@Autowired
	private JdbcTemplate jdbcTemplete;

	/*
	 * 1º parametro é o comando sql (um PreparedStatement)e o restante é a
	 * complementação do generic
	 */
	public Cliente salvar(Cliente cliente) {
		jdbcTemplete.update(INSERT, new Object[] { cliente.getNome() });
		return cliente;
	}

	/*
	 * 1º parametro é o comando sql (um PreparedStatement)e o restante é a
	 * complementação do generic
	 */
	public void atualizar(String nomeAntigo, String nomeNovo) {
		jdbcTemplete.update(UPDATE, new Object[] { nomeAntigo, nomeNovo });
	}

	/*
	 * 1º parametro é o comando sql (um PreparedStatement)e o restante é a
	 * complementação do generic
	 */
	public void deletar(Cliente cliente) {
		deletar(cliente.getId());
	}

	/* sobrecarga de metodo, se quiser pode deletar passando direto o ID */
	public void deletar(Integer id) {
		jdbcTemplete.update(DELETE, new Object[] {id});
		System.out.println("será que deletou?");
	}

	
	/*
	 * mesma ideia do obter todos, usa o .query para retornar uma lista
	 * usa o SQL como primeiro parametro
	 * cria um objeto para completar o generic
	 * e por fim usa o RowMapper para ele retornar o resultado da pequisa.
	 * */
	public List<Cliente> buscarPorNome(String nome) {
		return jdbcTemplete.query(BUSCA_NOME, new Object[] {"%"+nome+"%"}
				, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        });
			
		
	}

	/*
	 * jdbcTemplete.query com o comando SQL descrito acima, e o rowmapper vai mapear
	 * o banco de dados, e vai retortar o resultSet com o nome e id de cada cliente.
	 */
	public List<Cliente> obterTodos() {
		return jdbcTemplete.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				return new Cliente(id, nome);
			}
		});

	}
}
