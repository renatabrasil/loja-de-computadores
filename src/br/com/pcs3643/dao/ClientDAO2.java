package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Cliente2;

public class ClientDAO2 extends GenericDAO
{
	private Connection connection;
	
	public ClientDAO2() throws SQLException {
		this.connection = getConnection();		
	}
	
	public Cliente2 create (Cliente2 cliente) throws SQLException
	{
		if (cliente.validate())
		{
			PreparedStatement pstm = this.connection.prepareStatement("INSERT INTO cliente (nome, cpf, email, endereco, telefone) "
					+ "values (?, ?, ?, ?, ?)");
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCPF());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getTelefone());
			
			pstm.executeUpdate();
			pstm.close();
		}
		
		return cliente;
		
	}
	
	
	public Cliente2 read(int id) throws SQLException
	{
		Cliente2 cliente = new Cliente2();
		
		Connection connection = getConnection();
		
		PreparedStatement pstm = connection.prepareStatement("SELECT * FROM clientes ");
		
		ResultSet rs = pstm.executeQuery();
		
		
		while(rs.next()){
			
			cliente.setId(rs.getLong("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCPF(rs.getString("cpf"));
			cliente.setEmail(rs.getString("email"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
		}
		pstm.close();
		
		return cliente;
	}
	
	public List<Cliente2> getAll () throws SQLException
	{
		List<Cliente2> clientes = new ArrayList<>();
		
		PreparedStatement pstm = this.connection.prepareStatement("SELECT * FROM " + Cliente2.class.getSimpleName());
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()){
			Cliente2 cliente = new Cliente2();
			
			cliente.setId(rs.getLong("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCPF(rs.getString("cpf"));
			cliente.setEmail(rs.getString("email"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			
			clientes.add(cliente);
		}
		pstm.close();
		
		return clientes;
	}
}
