package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private static Connection connection =  null;
	
	public static Connection getConnection() throws Exception {

		if (connection != null)
			return connection;
		else  {

			String url =  "jdbc:mysql://localhost:3306/INK";
			String user="root";
			String password="admin";

			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {

				System.out.println("STATUS--->Conectado com sucesso!");

			} else {
				System.out.println("STATUS--->Não foi possivel realizar conexão");
			}
			connection.setAutoCommit(true);
			
			return connection;
		} //else
		
	} //Connection
}
