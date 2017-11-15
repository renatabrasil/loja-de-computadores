package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Peca;



public class PecaDAO {
	private Connection connection = null;
	
	public PecaDAO() {
		// TODO Auto-generated constructor stub
		connection = getConnection();
	}
	
	public void close() throws SQLException{
		if (connection != null) {
			connection.close();
		}
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/grupo02",
					"root", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public boolean createPeca(Peca peca) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO peca VALUES ("+peca.getIdPeca()+",'"+peca.getNome()+"',"+
						peca.getPreco()+",'"+peca.getDescricao()+"','"+peca.getTipo()+"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
	
	public Peca findByIdPeca(int id) throws SQLException{
		Statement statement = null;
		Peca peca = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM peca WHERE idPeca = " + id);
			
			peca = new Peca();
			
			peca.setIdPeca(resultSet.getInt("idPeca"));
			peca.setNome(resultSet.getString("nome"));
			peca.setTipo(resultSet.getString("tipo"));
			peca.setPreco(resultSet.getDouble("preco"));
			peca.setDescricao(resultSet.getString("descricao"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
		return peca;
	}
	
	public List<Peca> getAll() throws SQLException{
		Statement statement = null;
		List<Peca> pecas = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM peca");
			
			while (resultSet.next()) {
				Peca peca = new Peca();
				
				peca.setIdPeca(resultSet.getInt("idPeca"));
				peca.setNome(resultSet.getString("nome"));
				peca.setTipo(resultSet.getString("tipo"));
				peca.setPreco(resultSet.getDouble("preco"));
				peca.setDescricao(resultSet.getString("descricao"));
				
				pecas.add(peca);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return pecas;
	}
	
	public boolean updatePeca(Peca peca) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("UPDATE peca SET nome = "+peca.getNome()+", preco = "+
						peca.getPreco()+", descricao = "+peca.getDescricao()+", tipo = "+
						peca.getTipo()+" WHERE idPeca = " + peca.getIdPeca());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
	
	public boolean removePeca(int idPeca) throws SQLException{
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeQuery("DELETE FROM peca WHERE idPeca = " + idPeca);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
}
