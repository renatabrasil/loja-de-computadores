package br.com.pcs3643.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
//        	Class.forName("org.mariadb.jdbc.Driver");
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/grupo06", "root", "admin");
        } catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}