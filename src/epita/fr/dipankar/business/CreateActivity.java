package epita.fr.dipankar.business;

import java.sql.SQLException;
import java.util.Scanner;

import epita.fr.dipankar.datamodel.Identity;
import epita.fr.dipankar.services.IdentityJDBCDAO;

public class CreateActivity {

	 static IdentityJDBCDAO dao=new IdentityJDBCDAO ();

	public static void create(Scanner scanner) throws SQLException {
		System.out.println("Identity Creation");
		System.out.println("please enter your FirstName");
		
		
		 String FirstName = scanner.nextLine();
		System.out.println("please enter your LastName");
		String LastName = scanner.nextLine();
		System.out.println("please enter your email address");
		String email = scanner.nextLine();
		System.out.println("please enter your ContactNumber");
		 
		
		 int ContactNumber = scanner.nextInt();
		
		System.out.println("please enter your uid");
		 int uid = scanner.nextInt();
		
		Identity identity = new Identity(uid,FirstName,LastName,email,ContactNumber);
		dao.insert(identity);
		System.out.println("usuer created succesfully");
	}

	public static void update(Scanner scanner) throws SQLException {
		System.out.println("please enter your uid to update ");
		int uid = scanner.nextInt();
		System.out.println("Identity Creation");
		System.out.println("please enter your FirstName");
		String FirstName = scanner.nextLine();
		System.out.println("please enter your LastName");
		String LastName = scanner.nextLine();
		System.out.println("please enter your email address");
		String email = scanner.nextLine();
		System.out.println("please enter your ContactNumber");
		int ContactNumber = scanner.nextInt();
		
		Identity identity = new Identity(uid,FirstName,LastName,email,ContactNumber);
		dao.update(identity);
		System.out.println("row updated succesfully");
			
		
	}

	public static void delete(Scanner scanner) throws SQLException {
		System.out.println("please enter your uid to delete");
		int uid = scanner.nextInt();
		Identity identity = new Identity(uid,null,null,null,0);
		dao.delete(identity);
		System.out.println("Row deleted succesfully");
			
		
			
		
	}

	public static  void show() throws SQLException {
		
		dao.show();
	}
}
