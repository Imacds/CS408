#include <iostream>
#include <algorithm>
#include <vector>
#include "SetADT.cpp"
using namespace std;

// Non ADT Set
void nonADTSet();
// Union of two sets
vector<int> operator+(vector<int> lhs, vector<int> rhs);
// Intersection of two sets
vector<int> operator&(vector<int> set1, vector<int> set2);
// Difference of two sets
vector<int> operator-(vector<int> set1, vector<int> set2);
// Printing a set
void toString(vector<int>& v);
// Menu
void menu();
// ADT version
void adtSetTest();

int main() {

	cout << "Which version of Set would you like to test?" << endl;
	cout << "1 - Non-ADT version" << endl;
	cout << "2 - ADT version" << endl;

	int input;
	cin >> input;
	if (input == 1) {
		nonADTSet();
	}
	else if (input == 2) {
		adtSetTest();
	}
	else {
		cout << "Input is not valid." << endl;
	}

	return 0;
}

/**
 * This function performs the non-ADT version of Set
 */
void nonADTSet() {
	vector<int> nonADTSet1;
	vector<int> nonADTSet2;

	// Ask user to input the sets
	cout << "Enter integers for Set 1: (-999 to stop)" << endl;
	int element;
	cin >> element;
	while (element != -999) {
		if (find(nonADTSet1.begin(), nonADTSet1.end(), element) != nonADTSet1.end()) {
			cout << "The integer \"" << element << "\" already exists in the set!" << endl;
		}
		else {
			nonADTSet1.push_back(element);
		}
		cin >> element;
	}
	cout << "Set 1: ";
	toString(nonADTSet1);

	cout << "Enter integers for Set 2: (-999 to stop)" << endl;
	cin >> element;
	while (element != -999) {
		if (find(nonADTSet2.begin(), nonADTSet2.end(), element) != nonADTSet2.end()) {
			cout << "The integer \"" << element << "\" already exists in the set!" << endl;
		}
		else {
			nonADTSet2.push_back(element);
		}
		cin >> element;
	}
	cout << "Set 2: ";
	toString(nonADTSet2);

	// What to do with them
	menu();
	string input;
	cin >> input;
	while (input != "e") {
		if (input == "u") {
			vector<int> unionSet = nonADTSet1 + nonADTSet2;
			cout << "Union of Set 1 and Set 2: ";
			toString(unionSet);
			menu();
			cin >> input;
		}
		else if (input == "i") {
			vector<int> intersectionSet = nonADTSet1 & nonADTSet2;
			cout << "Intersection of Set 1 and Set 2: ";
			toString(intersectionSet);
			menu();
			cin >> input;
		}
		else if (input == "d") {
			vector<int> differenceSet = nonADTSet1 - nonADTSet2;
			cout << "Difference of Set 1 and Set 2: ";
			toString(differenceSet);
			menu();
			cin >> input;
		}
		else {
			cout << "That is not a valid command." << endl;
			menu();
			cin >> input;
		}
	}
	cout << "Exiting the program." << endl;
}

/**
 * This function performs union between two sets (vectors)
 */
vector<int> operator+(vector<int> set1, vector<int> set2) {
	vector<int> output;
	for (int i = 0; i < set1.size(); i++) {
		output.push_back(set1[i]);
	}
	for (int i = 0; i < set2.size(); i++) {
		if (find(output.begin(), output.end(), set2[i]) != output.end()) {
			cout << "The integer \"" << set2[i] << "\" already exists in the set!" << endl;
		}
		else {
			output.push_back(set2[i]);
		}
	}
	return output;
}

/**
 * This function performs intersection between two sets (vectors)
 */
vector<int> operator&(vector<int> set1, vector<int> set2) {
	vector<int> output;
	for (int i = 0; i < set1.size(); i++) {
		if (find(set2.begin(), set2.end(), set1[i]) != set2.end()) {
			output.push_back(set1[i]);
		}
	}
	return output;
}

/**
 * This function performs difference between two sets (vectors)
 */
vector<int> operator-(vector<int> set1, vector<int> set2) {
	vector<int> output;
	vector<int>::iterator it;
	for (int i = 0; i < set1.size(); i++) {
		output.push_back(set1[i]);
	}
	for (int i = 0; i < set2.size(); i++) {
		if (find(output.begin(), output.end(), set2[i]) != output.end()) {
			it = find(output.begin(), output.end(), set2[i]);
			output.erase(it);
		}
		else {
			output.push_back(set2[i]);
		}
	}
	return output;
}

/**
 * This function prints out the vector/set.
 */
void toString(vector<int>& v) {
	if (v.empty()) {
		cout << "[ ]" << endl;
	}
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v.back() << "]" << endl;
}

/**
 * This function prints the non-ADT menu.
 */
void menu() {
	cout << "What would you like to do with your sets?" << endl;
	cout << "\"u\" : perform union between the two sets" << endl;
	cout << "\"i\" : perform intersection between the two sets" << endl;
	cout << "\"d\" : perform difference between the two sets" << endl;
	cout << "\"e\" : exit this program" << endl;
}

void adtSetTest() {
	// Ask for first set
	SetADT set1;
	cout << "Enter values for Set 1: (\"-999\" to stop)" << endl;
	int input;
	cin >> input;
	while (input != -999) {
		set1.addElement(input);
		cin >> input;
	}
	cout << "First set inputed: ";
	set1.toString();

	// Ask for second set
	SetADT set2;
	cout << "Enter values for Set 2: (\"-999\" to stop)" << endl;
	int input2;
	cin >> input2;
	while (input2 != -999) {
		set2.addElement(input2);
		cin >> input2;
	}
	cout << "Second set inputed: ";
	set2.toString();

	// Menu
	menu();
	string menuInput;
	cin >> menuInput;
	while (menuInput != "e") {
		if (menuInput == "u") {
			SetADT set3 = set1 + set2;
			cout << "Union of Set 1 and Set 2: ";
			set3.toString();
			menu();
			cin >> menuInput;
		}
		else if (menuInput == "i") {
			SetADT set3 = set1 & set2;
			cout << "Intersection of Set 1 and Set 2: ";
			set3.toString();
			menu();
			cin >> menuInput;
		}
		else if (menuInput == "d") {
			SetADT set3 = set1 - set2;
			cout << "Difference of Set 1 and Set 2: ";
			set3.toString();
			menu();
			cin >> menuInput;
		}
		else {
			cout << "That is not a valid command." << endl;
			menu();
			cin >> menuInput;
		}
	}
	cout << "Exiting the program." << endl;
}
