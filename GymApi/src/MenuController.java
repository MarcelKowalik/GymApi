/*
 * This is a driver class that uses the console I/O to interact with the user.
 * @version 1
 * @author Marcel Kowalik
 */
import java.util.HashMap;
import java.util.Scanner;


public class MenuController {
	
public static HashMap<String,String> collegesAndAssociations = fillCollegesAndAssociations();
private Scanner input;
GymApi gymApi = new GymApi();

	/**
	 * Hard coding the packages into the HashMap.
	 */
private static HashMap<String,String> fillCollegesAndAssociations(){
	collegesAndAssociations = new HashMap<String,String>();
	collegesAndAssociations.put("Package 1", "Allowed access anytime to gym.\nFree access to all classes.\nAccess to all changing areas including deluxe changing rooms.");
	collegesAndAssociations.put("Package 2", "Allowed access anytime to gym.\n€3 fee for all classes.\nAccess to all changing areas including deluxe changing rooms.");
	collegesAndAssociations.put("Package 3", "Allowed access to gym at off-peak times.\n€5 fee for allclasses. \nNo access to deluxe changing rooms.");
	collegesAndAssociations.put("WIT", "Allowed access to gym during term time.\n€4 fee for all classes.\nNo access to deluxe changing rooms.");
	return collegesAndAssociations;
}

public MenuController(){
	input = new Scanner(System.in);
	try{
		gymApi.load();
	}catch(Exception e){
		System.out.println(e);
	}
	run();
}

public static void main(String args[]){
	MenuController app = new MenuController();
}

	//Menu
private int mainMenu(){
	System.out.println("Hi!, pick of of the options. :)");
	System.out.println("  1) Login");    
	System.out.println("  2) Register");
	System.out.println("  0) Exit");
	System.out.print("==>> ");
	try {
		int option = input.nextInt();
		return option;	
	}
	catch (Exception e){
		System.out.println("Error invalid Option");
	}
	return -1;

}
	
	private void run(){
		int option = mainMenu();
		while (option != 0)
		{
	
			switch(option){
			case 1:
				login();
				break;
			case 2:
				register();
				break;  
				default:       System.out.println("Invalid option entered: " + option);
				break;
				}
	
				System.out.println("\nPress any key to continue...");
				input.nextLine();
				input.nextLine();  //this second read is required - bug in Scanner class; a String read is ignored straight after reading an int.
	
				//clear the terminal window and display the main menu again
				System.out.println("\f");
				option = mainMenu();
			}   
			System.out.println("Exiting... bye");
			System.exit(0);
	}
	
	private void login(){
		System.out.println("Who do you want to login as?");
		System.out.println("1) Login as a Member"); 
		System.out.println("2) Login as a Trainer");
		int choice = input.nextInt();
		input.nextLine();
		
		switch(choice){
		case 1:
    		//loginMember();
    		break;
		case 2:
    		//loginTrainer();
			break;
			default:       System.out.println("Invalid option entered: " + choice);
			break;
		}
	}
	
	private void register(){
		System.out.println("Who do you want to registar as?");
		System.out.println("1) Register a new Member."); 
		System.out.println("2) Register a new Trainer");
		int choice = input.nextInt();
		input.nextLine();
		
		switch(choice){
		case 1:
    		//registerMember();
    		break;
		case 2:
    		//registerTrainer();
			break;
			default:       System.out.println("Invalid option entered: " + choice);
			break;
		}
	}
	
	
	private void registerMember(){
	}

	private void registerTrainer(){
	}

	private void loginMember(){
		System.out.println("Please enter your email address:");
	}
	
	private void loginTrainer(){
		System.out.println("Please enter your email address:");	
	}
	
}

