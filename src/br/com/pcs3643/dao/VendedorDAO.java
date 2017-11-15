package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Vendedor;

public class VendedorDAO {
	private Connection connection;
	public VendedorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	public boolean insert(Vendedor vendedor) throws SQLException{
		Statement statement = null;
		
		statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO Vendedor (IDVendedor) VALUES (" + vendedor.getId() +")");
		return true;
	}
		
	public List<Vendedor> getAll() throws SQLException {
		Statement statement = null;
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Vendedor");
			
			while(resultSet.next()) {
				Vendedor vendedor = new Vendedor();
				
				vendedor.setId(resultSet.getInt("IDVendedor"));
				vendedores.add(vendedor);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return vendedores;
	}
	
	public boolean update(Vendedor vendedor) throws SQLException {
		Statement statement = null;
		
		statement = connection.createStatement();
		statement.executeUpdate("UPDATE Vendedor SET id ="+vendedor.getId() +"WHERE id = "+vendedor.getId());
		return true;
		
	}
}
