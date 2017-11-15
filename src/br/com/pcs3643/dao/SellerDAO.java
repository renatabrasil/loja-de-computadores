package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Seller;

public class SellerDAO {
	private Connection connection = null;
	
	public SellerDAO() {
	  connection = new ConnectionFactory().getConnection();
	}
	
	public List<Seller> getAll() throws SQLException {
	  Statement statement = null;
	  List<Seller> sellers = new ArrayList<Seller>();
	  
	  try {
	    statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM Seller");
	    
	    while (resultSet.next()) {
	      Seller seller = new Seller();
	      
	      seller.setId(resultSet.getInt("id"));
	      seller.setName(resultSet.getString("name"));
	      seller.setCpf(resultSet.getString("cpf"));
	      seller.setAddress(resultSet.getString("address"));
	      seller.setEmail(resultSet.getString("email"));
	      seller.setPhone(resultSet.getString("phone"));
	      
	      sellers.add(seller);
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } finally {
	    statement.close();
    }
	  
	  return sellers;
	}
	
	public Seller findById (int id) throws SQLException {
	  Statement statement = null;
	  Seller seller = new Seller();
	  
	  try {
	    statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM Seller" + 
	                                                 "WHERE id = " + id);
	    
	    seller.setId(resultSet.getInt("id"));
	    seller.setName(resultSet.getString("name"));
      seller.setCpf(resultSet.getString("cpf"));
      seller.setAddress(resultSet.getString("address"));
      seller.setEmail(resultSet.getString("email"));
      seller.setPhone(resultSet.getString("phone"));
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } finally {
      statement.close();
    }
	  
	  return seller;
	}
	
	public boolean create (Seller seller) throws SQLException {
	  Statement statement = null;
	  
	  try {
	    statement = connection.createStatement();
	    
	    statement.executeUpdate("INSERT INTO Seller" + 
                   " (name, cpf, address, email, phone, password, id)" + 
	                 " values ('" + seller.getName() + "', '" + seller.getCpf() + "', '" + seller.getAddress() + "', '" + 
                   seller.getEmail() + "', '" + seller.getPhone() + "', '" + seller.getPassword() + "', '" + seller.getId() +"')");
	    
	    return true;
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } finally {
      statement.close();
    }
	  
	  return false;
	}
}
