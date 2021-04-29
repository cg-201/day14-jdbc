package day14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainV3 {
	public static void main(String[] args) throws Exception {

		// DB CREDENTIALS and INFO
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/project-db1";
		String username = "postgres";
		String password = "postgres";

		// Step 1 :: Loading the Driver/Interpter
		Class.forName(driver);

		// STEP 2 :: Open Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		
		System.out.println("Connection Success!");
		
		
		// LAST CLose the connect
		connection.close();
	}

}
