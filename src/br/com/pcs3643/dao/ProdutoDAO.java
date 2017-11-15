package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.pcs3643.models.Produto;

public class ProdutoDAO {

		  // a conexão com o banco de dados
		  private Connection connection;

		  public ProdutoDAO() {
		    this.connection = new ConnectionFactory().getConnection();
		  }
		  
		  public Produto getProduto(int id) {
			        try {
			        	Statement  stmt = connection.createStatement();
			            ResultSet rs = stmt.executeQuery("SELECT * FROM Produto WHERE id=" + id);
			            if(rs.next())
			            {
			                Produto produto = new Produto();
			                produto.setId( rs.getInt("id") );
			                produto.setTipo( rs.getString("Tipo") );
			                produto.setNome( rs.getString("Nome") );
			                return produto;
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    return null;
			}
		  
		  public ArrayList<Produto> getTodosProdutos() {
		        try {
		        	Statement  stmt = connection.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM Produto");
		            ArrayList<Produto> lista = new ArrayList<Produto>();
		            while(rs.next())
		            {
		                Produto produto = new Produto();
		                produto.setId( rs.getInt("id") );
		                produto.setTipo( rs.getString("Tipo") );
		                produto.setNome( rs.getString("Nome") );
		                lista.add(produto);
		            }
		            return lista;
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    return null;
		}
		  
		  public void insertProduto(Produto produto) {
		        try {
		        	Statement  stmt = connection.createStatement();
		            stmt.executeUpdate("INSERT INTO produto (preco, tipo, nome) "
		            		+ "VALUES ('"+produto.getPreço()+"', '"+produto.getTipo()+"', '"+ produto.getNome()+"');");

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		}
}
