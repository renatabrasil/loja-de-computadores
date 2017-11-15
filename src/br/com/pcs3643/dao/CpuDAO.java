package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.models.Cpu;

public class CpuDAO {
  private Connection connection = null;

  public CpuDAO(){
    this.connection = new ConnectionFactory().getConnection();
  }

  public List<Cpu> getAll() throws SQLException {
    Statement statement = null;
    List<Cpu> products = new ArrayList<Cpu>();
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM CPU");
      while(resultSet.next()){
        Cpu cpu = new Cpu();
        cpu.setId(resultSet.getInt("id"));
        cpu.setName(resultSet.getString("name"));
        cpu.setPrice(resultSet.getFloat("price"));
        cpu.setSocket(resultSet.getString("socket"));
        products.add(cpu);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      statement.close();
    }
    return products;
  }

  public boolean create(Cpu cpu) throws SQLException {
    String sql = "INSERT INTO Cpu (name, price, socket) VALUES (?,?,?)";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, cpu.getName());
      statement.setFloat(2, cpu.getPrice());
      statement.setString(3, cpu.getSocket());
      statement.execute();
      statement.close();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
