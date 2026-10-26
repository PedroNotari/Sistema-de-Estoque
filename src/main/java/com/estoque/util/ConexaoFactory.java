package com.estoque.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.estoque.exception.ConexaoException;

public class ConexaoFactory {

	public static Connection getConexao() {
		Properties props = new Properties();

		try (FileInputStream fis = new FileInputStream("config/db.properties")) {
			props.load(fis);

			String url = props.getProperty("db.url");
			String user = props.getProperty("db.user");
			String password = props.getProperty("db.password");

			return DriverManager.getConnection(url, user, password);

		} catch (IOException | SQLException e) {
			throw new ConexaoException("Não foi possível conectar ao banco de dados", e);
		}
	}
}
