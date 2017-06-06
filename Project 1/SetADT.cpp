#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class SetADT {

private:
	vector<int> setList;

public:
	/**
	 * Constructor
	 */
	SetADT() {
		setList = { };
	}

	/**
	 * This function adds an element to the set.
	 */
	void addElement(int element) {
		if (find(setList.begin(), setList.end(), element) != setList.end()) {
			cout << "The integer \"" << element << "\" already exists in the set!" << endl;
		}
		else {
			setList.push_back(element);
		}
	}

	/**
	 * This function removes an element from the set.
	 */
	void removeElement(int element) {
		vector<int>::iterator it;
		for (int i= 0; i < setList.size(); i++) {
			if (find(setList.begin(), setList.end(), element) != setList.end()) {
				it = find(setList.begin(), setList.end(), element);
				setList.erase(it);
			}
		}
	}

	/**
	 * This function retrieves an element at a targeted index.
	 */
	int get(int index) {
		return setList.at(index);
	}

	/**
	 * This function retrieves the size of the set.
	 */
	int size() {
		return setList.size();
	}

	/**
	 * This function returns if a set is empty or not.
	 */
	bool isEmpty() {
		return setList.empty();
	}

	/**
	 * This function checks to see if an element is contained in the set.
	 */
	bool contains(int element) {
		if (find(setList.begin(), setList.end(), element) != setList.end()) {
			return true;

		}
		else {
			return false;
		}
	}

	/**
	 * This function prints out the set.
	 */
	void toString() {
		if (setList.empty()) {
			cout << "[ ]" << endl;
		}

		cout << "[";
		for (int i = 0; i < setList.size() - 1; i++) {
			cout << setList[i] << ", ";
		}
		cout << setList.back() << "]" << endl;
	}

	/**
	 * Union two Sets together.
	 */
	friend SetADT operator+(SetADT set1, SetADT set2) {
		SetADT unionSet;
		for (int i = 0; i < set1.size(); i++) {
			unionSet.addElement(set1.get(i));
		}
		for (int i = 0; i < set2.size(); i++) {
			if (!unionSet.contains(set2.get(i))) {
				unionSet.addElement(set2.get(i));
			}
			else {
				cout << "The integer \"" << set2.get(i) << "\" already exists in the set!" << endl;
			}
		}
		return unionSet;
	}

	/**
	 * Intersection of two Sets.
	 */
	friend SetADT operator&(SetADT set1, SetADT set2) {
		SetADT intersectionSet;
		for (int i = 0; i < set1.size(); i++) {
			if (set2.contains(set1.get(i))) {
				intersectionSet.addElement(set1.get(i));
			}
		}
		return intersectionSet;
	}

	/**
	 * Difference of two Sets.
	 */
	friend SetADT operator-(SetADT set1, SetADT set2) {
		SetADT differenceSet;
		for (int i = 0; i < set1.size(); i++) {
			differenceSet.addElement(set1.get(i));
		}
		for (int i = 0; i < set2.size(); i++) {
			if (differenceSet.contains(set2.get(i))) {
				differenceSet.removeElement(set2.get(i));
				cout << "Removing " << set2.get(i) << endl;
			}
			else {
				differenceSet.addElement(set2.get(i));
				cout << "Adding " << set2.get(i) << endl;
			}
		}
		return differenceSet;
	}
};



