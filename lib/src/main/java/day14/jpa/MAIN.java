package day14.jpa;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MAIN {

	public static void main(String[] args) {
		
		// Lil Unfriendly
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager em = factory.createEntityManager();
		
		
		// Creating Object  :: dbinfo
		Employee employee =new Employee(1, "rahul", "rahul@gmail.com", "12122", 23233, true, LocalDateTime.now());
		em.getTransaction().begin();
		em.persist(employee); // add the record into database
		em.getTransaction().commit();
		
		System.out.println("Record Added!!");
	}
}
