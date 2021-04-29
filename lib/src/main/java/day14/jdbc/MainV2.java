package day14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainV2 {
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
		
		// PERFORM SOME QUERY
		String sql = "INSERT INTO t2 (id, name, email, mobile, salary) values (?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql); // Sql String to Sql Statment
		ps.setInt(1, 103);
		ps.setString(2, "rahul");
		ps.setString(3, "rahul@gmail.com");
		ps.setString(4, "323223232");
		ps.setInt(5, 10000);
		
		// EXECUTE
		ps.executeUpdate();
		
		
		// LAST CLose the connect
		connection.close();
		System.out.println("Record Added");
	}

}
