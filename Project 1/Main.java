import java.util.Scanner;

public class Main {

	public static <T> void main(String[] args) {
////		SetADT<Integer> set5 = set1.difference(set2);
////		System.out.println("Set 5: difference of 1 and 2: " + set5.toString());
		
		Scanner kb = new Scanner(System.in);

		// Ask for first Set
		SetADT<T> set1 = new SetADT<>();
		System.out.println("Enter values for Set 1: (\"exit\" to stop)");
		T input = (T)kb.next();
		while (!input.equals("exit")) {
			set1.addElement(input);
			input = (T)kb.next();
		}
		System.out.println("First set inputted: " + set1.toString());
		
		// Ask for second Set
		SetADT<T> set2 =  new SetADT<>();
		System.out.println("Enter values for Set 2: (\"exit\" to stop)");
		T input2 = (T)kb.next();
		while (!input2.equals("exit")) {
			set2.addElement(input2);
			input2 = (T)kb.next();
		}
		System.out.println("Second set inputted: " + set2.toString());
		
		// Menu
		System.out.println("What would you like to do with these sets now?");
		System.out.println("\"u\" for union");
		System.out.println("\"i\" for intersection");
		System.out.println("\"d\" for difference");
		System.out.println("\"e\" to exit");
		String menuInput = kb.next();
		
		while (!menuInput.equals("e")) {
			if (menuInput.equals("u")) {
				SetADT<T> set3 = set1.union(set2);
				System.out.println("Union of Set 1 and Set 2: " + set3.toString());
			}
			else if (menuInput.equals("i")) {
				SetADT<T> set3 = set1.intersection(set2);
				System.out.println("Intersection of Set 1 and Set 2: " + set3.toString());
			}
//			else if (menuInput.equals("d")) {
//			 	SetADT<T> set3 = set1.difference(set2);
//			}
			else {
				System.out.println("That is not a valid command.");
			}
		}
			
	}

}
