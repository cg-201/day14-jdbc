package day14.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MAIN2 {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		// Lil Unfriendly
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager em = factory.createEntityManager();

		// Creating Object :: dbinfo
		Employee employee = new Employee();

		System.out.println("Enter User Id");
		employee.setId(scanner.nextInt());

		System.out.println("Enter Name");
		employee.setName(scanner.next());

		System.out.println("Enter Email");
		employee.setEmail(scanner.next());

		System.out.println("Enter Mobile");
		employee.setMobile(scanner.next());

		System.out.println("Enter DOB");
		String dob = scanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		employee.setTimestamp(LocalDateTime.now());
		// employee.setTimestamp(LocalDateTime.parse(dob, formatter));
		employee.setDob(LocalDate.parse(dob, formatter));

		em.getTransaction().begin();
		em.persist(employee); // add the record into database
		em.getTransaction().commit();

		System.out.println("Record Added!!");
		scanner.close();
	}
}
