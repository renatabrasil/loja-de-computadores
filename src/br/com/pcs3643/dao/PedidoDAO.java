package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Pedido;

public class PedidoDAO {
	private Connection connection;
	
	public PedidoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean create(Pedido pedido) throws SQLException {
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Pedido VALUES (" + Integer.toString(pedido.getIdPedido()) + ", " + String.valueOf(pedido.getPreco()) + ", " + String.valueOf(pedido.getDesconto()) + ", " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(pedido.getTimestamp()) + ")");
		} finally {
			statement.close();
		}
		
		return true;
	}
	
	public Pedido findByPrimaryKey(int id) throws SQLException {
		return new Pedido(1, 3.0, 3.0, new Timestamp(System.currentTimeMillis()));
	}
	
	public List<Pedido> getAll() throws SQLException {
		Statement statement = null;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		try {
			connection = new ConnectionFactory().getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Pedido");
			
			while(resultSet.next()){
				Pedido pedido = new Pedido();
				
				pedido.setIdPedido(resultSet.getInt("IdPedido"));
				pedido.setPreco(resultSet.getDouble("Preco"));
				pedido.setDesconto(resultSet.getDouble("Desconto"));
				pedido.setTimestamp(resultSet.getTimestamp("Timestamp"));
				
				pedidos.add(pedido);
			}
		} finally {
			statement.close();
		}
		
		return pedidos;
	}
	
	public boolean update(Pedido pedido) throws SQLException {
		return true;
	}
	
	public boolean remove(int id) throws SQLException {
		return true;
	}
}
