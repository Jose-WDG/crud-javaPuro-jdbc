package br.com.ecommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/ecommerce?useSSL=false", "root", "81776279");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
