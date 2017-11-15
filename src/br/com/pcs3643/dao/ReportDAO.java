package br.com.pcs3643.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Purchase;
import br.com.pcs3643.models.Seller;

public class ReportDAO {
	private Connection connection;
	
	public ReportDAO () throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Purchase> getAllPurchases(String month) throws SQLException {
		Statement statement = null;
		List<Purchase> purchases = new ArrayList<Purchase>();
		
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Pedido WHERE month='" + month+ "'");
			
			while (result.next()) {
				Purchase p = new Purchase();
				
				p.setId_pedido(result.getInt("id"));
				p.setClient(result.getString("cliente"));
				p.setMotherboard(result.getString("motherboard"));
				p.setMemory(result.getString("memory"));
				p.setHd(result.getString("hd"));
				p.setCpu(result.getString("cpu"));
				p.setMotherboard_qty(result.getInt("motherboard_quantity"));
				p.setMemory_qty(result.getInt("memory_quantity"));
				p.setHd_qty(result.getInt("hd_quantity"));
				p.setCpu_qty(result.getInt("cpu_quantity"));
				p.setTotal(result.getDouble("total"));
				
				purchases.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		}
		
		return purchases;
	}
	
	public List<Seller> getAllSellers() throws SQLException {
		Statement statement = null;
		List<Seller> sellers = null;
		
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Vendedor");
			
			while (result.next()) {
				Seller s = new Seller();
				
//				s.setId_pedido(result.getInt("id pedido"));
//				s.setId_seller(result.getInt("id vendedor"));
//				s.setName(result.getString("name"));
//				
//				sellers.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		}
		return sellers;
	}

}
