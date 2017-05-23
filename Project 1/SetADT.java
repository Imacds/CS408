/**
 * Nicholas Pham
 * CS 408: Programming Languages
 * Project 1: Set Data Structure
 * Description: Implement a Set data structure using ADTs and non ADTs. The Set operations that should surely be included are
 * 				union, intersection, and difference. Create a driver to test the operations and allow a user to use the operations.
 */

import java.util.ArrayList;

public class SetADT<T> {
	
	// ArrayList to hold values for Set
	private ArrayList<T> setList;
	
	/**
	 * Constructor for Set.
	 */
	public SetADT() {
		setList = new ArrayList<>();
	}
	
	/**
	 * Add element to the Set.
	 */
	public void addElement(T element) {
		if (!setList.contains(element)) {
			setList.add(element);
		}
		else {
			System.out.println("The element \"" + element + "\" already exists in the set!");
		}
	}
	
	/**
	 * Remove element from the Set.
	 */
	public void removeElement(T element) {
		if (setList.contains(element)) {
			setList.remove(element);
		}
	}
	
	public T get(int index) {
		return setList.get(index);
	}
	
	/**
	 * Get length / size of the Set.
	 */
	public int size() {
		return setList.size();
	}
	
	/**
	 * Returns if the Set is empty or not.
	 */
	public boolean isEmpty() {
		return setList.isEmpty();
	}
	
	/**
	 * Return if the Set contains the element or not.
	 */
	public boolean contains(T element) {
		if (setList.contains(element)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Union two Sets together.
	 */
	public SetADT<T> union(SetADT<T> set2) {
		SetADT<T> unionSet = new SetADT<>();
		for (int i = 0; i < setList.size(); i++) {
			unionSet.addElement(setList.get(i));
		}
		
		for (int i = 0; i < set2.size(); i++) {
			if (!setList.contains(set2.get(i))) {
				unionSet.addElement(set2.get(i));
//				setList.add(set2.get(i));
			}
			else {
				System.out.println("The element \"" + set2.get(i) + "\" already exists in the set!");
			}
		}
		return unionSet;
	}
	
	/**
	 * Intersection of two Sets.
	 */
	public SetADT<T> intersection(SetADT<T> set2) {
		SetADT<T> intersectionSet = new SetADT<>();
		for (T element : setList) {
			if (set2.contains(element)) {
				intersectionSet.addElement(element);
			}
		}
		return intersectionSet;
	}
	
	/**
	 * Difference of two Sets. Consists of elements that are in Set 1 (setList), 
	 * but NOT in B.
	 */
//	public SetADT<T> difference(SetADT<T> set2) {
//		SetADT<T> differenceSet = new SetADT<>();
//		for (T element : setList) {
//			differenceSet.addElement(element);
//		}
//		for (int i = 0; i < set2.size(); i++) {
//			if (differenceSet.contains(set2.get(i))) {
//				differenceSet.removeElement(set2.get(i));
//				System.out.println("Removing: " + set2.get(i));
//			}
//			else {
//				differenceSet.addElement(set2.get(i));
//				System.out.println("Adding: " + set2.get(i));
//			}
//		}
//		return differenceSet;
//	}
	
	/**
	 * Print the set as a String.
	 */
	public String toString() {
		return setList.toString();
	}
}
