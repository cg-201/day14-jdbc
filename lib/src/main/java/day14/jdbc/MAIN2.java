package day14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


// host all postgres postgres-client.docker_default trust
public class MAIN2 {

	public static void main(String[] args) throws Exception {
		// addRecord();
		updateRecord();
		
	}
	
	public static void updateRecord() throws Exception {
		// DB CREDENTIALS and INFO
		String driver = "org.postgresql.Driver"; 
		String url = "jdbc:postgresql://localhost:5432/project-db1";
		String username = "postgres";
		String password = "postgres";
		
		
		// Step 1 :: Loading the Driver
		Class.forName(driver);
		
		// STEP 2 :: Open Connection
		Connection connection =  DriverManager.getConnection(url, username, password);
		
		
		String sql = "UPDATE t2 SET name=?, email=?, salary=? WHERE id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "rohit");
		ps.setString(2, "rohit@gmail.com");
		ps.setInt(3, 100000);
		ps.setInt(4, 11);
		
		
		ps.executeUpdate();
		
		// finaly :: Close Connection
		connection.close();
		System.out.println("Update Done!!");
	}
	
	public static void addRecord() throws Exception {
		// I want to connect with database;
		// DB CREDENTIALS and INFO
		String driver = "org.postgresql.Driver"; 
		String url = "jdbc:postgresql://localhost:5432/project-db1";
		String username = "postgres";
		String password = "postgres";
		
		// Step 1 :: Loading the Driver
		Class.forName(driver);
		
		// STEP 2 :: Open Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		
		// STEP 3 :: STATMENT
		String sql = "INSERT INTO t2 (id, name, email, mobile, salary) values (?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 101);
		ps.setString(2, "rohit");
		ps.setString(3, "rohit@gmail.com");
		ps.setString(4, "323223232");
		ps.setInt(5, 10000);
		
		// STEP 4 
		ps.executeUpdate();
		
		// STEP 5
		connection.close();
		
		System.out.println("Record added!!");
	}
}
