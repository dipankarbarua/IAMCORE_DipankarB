package fr.epita.dipankar.launcher;

import java.sql.SQLException;
import java.util.Scanner;

import epita.fr.dipankar.business.CreateActivity;

public class ConsoleLauncher {
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome to the IAM software");
		Scanner scanner = new Scanner(System.in);
		
		//authentication
		if (!authenticate(scanner)){
			end(scanner);
			return;
		}
		
		//menu
		System.out.println("Please select an action :");
		System.out.println("a. create an Identity");
		System.out.println("b. modify an Identity");
		System.out.println("c. delete an Identity");
		System.out.println("d. show Identity");
		System.out.println("e. quit");
		String choice = scanner.nextLine();
		
		switch (choice) {
		case "a":
			//Create
			CreateActivity.create(scanner);
			break;
		case "b":
			//Modify
			CreateActivity.update(scanner);
			break;
			
		case "c":
			//Delete
			CreateActivity.delete(scanner);
			break;
		case "d":
			
			CreateActivity.show();
			break;
			
		case "e":
			//Quit
			break;
			
		default:
			System.out.println("Your choice is not recognized");
			break;
		}

		
		end(scanner);
	}

	/**
	 * @param scanner
	 */
	private static void end(Scanner scanner) {
		System.out.println("Thanks for using this application, good bye!");
		scanner.close();
	}

		
		
		
		

	
	private static boolean authenticate(Scanner scanner) {
		System.out.println("Please type your login : ");
		String login = scanner.nextLine();
		
		System.out.println("Please type your password : ");
		String password = scanner.nextLine();
		
		if (login.equals("adm") && password.equals("pwd")){
			System.out.println("Athentication was successful");
			return true;
		}else{
			System.out.println("Athentication failed");
			return false;
		}
	}

}
