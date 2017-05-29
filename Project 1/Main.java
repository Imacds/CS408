/**
 * Nicholas Pham
 * CS 408: Programming Languages
 * Project 1: Set Data Structure
 * Description: Implement a Set data structure using ADTs and non ADTs. The Set operations that should surely be included are
 * 		union, intersection, and difference. Create a driver to test the operations and allow a user to use the operations.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Which version of Set would you like to test?");
		System.out.println("1 - Non-ADT version");
		System.out.println("2 - ADT version");
		int input = kb.nextInt();
		if (input == 1) {
			nonADTSetTest();
		}
		else if (input == 2) {
			adtSetTest();
		}
		else {
			System.out.println("Input is not valid.");
		}
		
		
		kb.close();
	}
	
	/*********************************************************************/
	
	/**
	 * This method tests the non-ADT version of Set.
	 */
	public static void nonADTSetTest() {
		Scanner kb = new Scanner(System.in);
		ArrayList<Integer> nonADTSet1 = new ArrayList<>();
		ArrayList <Integer>nonADTSet2 = new ArrayList<>();

		System.out.println("Enter integers for Set 1 (-999 to stop): ");
		int element;
		element = kb.nextInt();
		while (element != -999) {
			if (!nonADTSet1.contains(element)) {
				nonADTSet1.add(element);
			}
			else {
				System.out.println("The integer \"" + element + "\" already exists in the set!");
			}
			element = kb.nextInt();
		}
		System.out.println("Set 1: " + nonADTSet1.toString());
		
		System.out.println("Enter integers for Set 2 (-999 to stop): ");
		element = kb.nextInt();
		while (element != -999) {
			if (!nonADTSet2.contains(element)) {
				nonADTSet2.add(element);
			}
			else {
				System.out.println("The integer \"" + element + "\" already exists in the set!");
			}
			element = kb.nextInt();
		}
		System.out.println("Set 2: " + nonADTSet2.toString());
		
		nonADTMenu();
		String input = kb.next();
		while (!input.equals("e")) {
			if (input.equals("u")) {
				ArrayList<Integer> nonADTUnion = union(nonADTSet1, nonADTSet2);
				System.out.println("Union of Set 1 and Set 2: " + nonADTUnion.toString());
				nonADTMenu();
				input = kb.next();
			}
			else if (input.equals("i")) {
				ArrayList<Integer> nonADTIntersection = intersection(nonADTSet1, nonADTSet2);
				System.out.println("Intersection of Set 1 and Set 2: " + nonADTIntersection.toString());
				nonADTMenu();
				input = kb.next();
			}
			else if (input.equals("d")) {
				ArrayList<Integer> nonADTDifference = difference(nonADTSet1, nonADTSet2);
				System.out.println("Difference of Set 1 and Set 2: " + nonADTDifference.toString());
				nonADTMenu();
				input = kb.next();
			}
			else {
				System.out.println("That is not a valid command.");
				nonADTMenu();
				input = kb.next();
			}
		}
		System.out.println("Exiting the program.");
	}

	/**
	 * This menu is for the non-ADT version of Set.
	 */
	public static void nonADTMenu() {
		System.out.println("What would you like to do with your sets?");
		System.out.println("\"u\" : perform union between the two sets");
		System.out.println("\"i\" : perform intersection between the two sets");
		System.out.println("\"d\" : perform difference between the two sets");
		System.out.println("\"e\" : exit this program");
	}
	
	/**
	 * This method is the non-ADT version of union.
	 */
	public static ArrayList<Integer> union(ArrayList<Integer> set1, ArrayList<Integer> set2) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < set1.size(); i++) {
			output.add(set1.get(i));
		}
		
		for (int i = 0; i < set2.size(); i++) {
			if (!set1.contains(set2.get(i))) {
				output.add(set2.get(i));
			}
			else {
				System.out.println("The element \"" + set2.get(i) + "\" already exists in the set!");
			}
		}
		return output;
	}
	
	/**
	 * This method is the non-ADT version of intersection.
	 */
	public static ArrayList<Integer> intersection(ArrayList<Integer> set1, ArrayList<Integer> set2) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int element : set1) {
			if (set2.contains(element)) {
				output.add(element);
			}
		}
		return output;	
	}
	
	/**
	 * This method is the non-ADT version of difference.
	 */
	public static ArrayList<Integer> difference(ArrayList<Integer> set1, ArrayList<Integer> set2) {
		ArrayList<Integer> output = new ArrayList<>();
		output.addAll(set1);
		for (int i = 0; i < set2.size(); i++) {
			if (output.contains(set2.get(i))) {
				output.remove(set2.get(i));
				System.out.println("Removing: " + set2.get(i));
			}
			else {
				output.add(set2.get(i));
				System.out.println("Adding: " + set2.get(i));
			}
		}
		return output;
	}
	
	/*********************************************************************/
	
	/**
	 * This method tests the ADT version of Set.
	 */
	public static <T> void adtSetTest() {
		Scanner kb = new Scanner(System.in);
		// Ask for first Set
		SetADT<T> set1 = new SetADT<>();
		System.out.println("Enter values for Set 1: (\"exit\" to stop)");
		T input = (T)kb.next();
		while (!input.equals("exit")) {
			set1.addElement(input);
			input = (T)kb.next();
		}
		System.out.println("First set inputed: " + set1.toString());
		
		// Ask for second Set
		SetADT<T> set2 =  new SetADT<>();
		System.out.println("Enter values for Set 2: (\"exit\" to stop)");
		T input2 = (T)kb.next();
		while (!input2.equals("exit")) {
			set2.addElement(input2);
			input2 = (T)kb.next();
		}
		System.out.println("Second set inputed: " + set2.toString());
		
		// Menu
		printMenu();
		String menuInput = kb.next();
		while (!menuInput.equals("e")) {
			if (menuInput.equals("u")) {
				SetADT<T> set3 = set1.union(set2);
				System.out.println("Union of Set 1 and Set 2: " + set3.toString());
				printMenu();
				menuInput = kb.next();
			}
			else if (menuInput.equals("i")) {
				SetADT<T> set3 = set1.intersection(set2);
				System.out.println("Intersection of Set 1 and Set 2: " + set3.toString());
				printMenu();
				menuInput = kb.next();
			}
			else if (menuInput.equals("d")) {
			 	SetADT<T> set3 = set1.difference(set2);
				System.out.println("Difference of Set 1 and Set 2: " + set3.toString());
			 	printMenu();
			 	menuInput = kb.next();
			}
			else {
				System.out.println("That is not a valid command.");
				printMenu();
				menuInput = kb.next();
			}
		}
		System.out.println("Exiting the program.");
	}
	
	/**
	 * This method prints out the menu and allows for a cleaner interface.
	 */
	public static void printMenu() {
		System.out.println("What would you like to do with these sets now?");
		System.out.println("\"u\" : perform union between the two sets");
		System.out.println("\"i\" : perform intersection between the two sets");
		System.out.println("\"d\" : perform difference between the two sets");
		System.out.println("\"e\" : exit this program");
	}

}
