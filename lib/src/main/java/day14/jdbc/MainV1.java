package day14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainV1 {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		
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
		
		System.out.println("Enter ID in Number ");
		ps.setInt(1, scanner.nextInt());
		
		System.out.println("Enter Username in String ");
		ps.setString(2, scanner.next());
		
		System.out.println("Enter Email in String ");
		ps.setString(3, scanner.next());
		
		System.out.println("Enter Mobile in String ");
		ps.setString(4, scanner.next());
		
		System.out.println("Enter Salary in Digit ");
		ps.setInt(5, scanner.nextInt());
		
		// EXECUTE
		ps.executeUpdate();
		
		
		// LAST CLose the connect
		connection.close();
		scanner.close();
		System.out.println("Record Added");
	}

}
