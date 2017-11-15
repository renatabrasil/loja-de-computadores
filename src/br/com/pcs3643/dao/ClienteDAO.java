package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Cliente;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
		public boolean create (Cliente cliente) throws SQLException{
			return false;}
		
		public Cliente findByPrimaryKey (int id) throws SQLException{
			return null;}
		
		public List<Cliente> getAll() throws SQLException{
			Statement statement = null;
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			try {
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * from Cliente");
				
				while (resultSet.next()) {
					Cliente cliente = new Cliente();
					
					cliente.setNome(resultSet.getString("Nome"));
					cliente.setCpf(resultSet.getInt("CPF"));
					cliente.setEndereco(resultSet.getString("Endereco"));
					cliente.setEmail(resultSet.getString("Email"));
					cliente.setTelefone(resultSet.getInt("Telefone"));
					
					clientes.add(cliente);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return clientes;
		}
		
		public boolean insert(Cliente cliente) throws SQLException{
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Cliente (Nome, CPF, Endereco, Email, Telefone) VALUES ('"+ 
			cliente.getNome() + "'," +
			cliente.getCpf() + ",'" +
			cliente.getEndereco() + "','" +
			cliente.getEmail() + "'," +
			cliente.getTelefone() + ")");
			
			return true;
		}
		
		public boolean update(Cliente cliente) throws SQLException{
			return false;}
		
		public boolean remove(int id) throws SQLException{
			return false;}
	

}
