#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// Union of two sets
vector<int> operator+(const vector<int>& lhs, const vector<int>& rhs);
// Intersection of two sets
vector<int> operator&(vector<int> set1, vector<int> set2);
// Difference of two sets
vector<int> operator-(vector<int> set1, vector<int> set2);
// Printing a set
void toString(vector<int>& v);
// Menu
void nonADTMenu();

int main() {

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
	nonADTMenu();
	string input;
	cin >> input;
	while (input != "e") {
		if (input == "u") {
			vector<int> unionSet = nonADTSet1 + nonADTSet2;
			cout << "Union of Set 1 and Set 2: ";
			toString(unionSet);
			nonADTMenu();
			cin >> input;
		}
		else if (input == "i") {
			vector<int> intersectionSet = nonADTSet1 & nonADTSet2;
			cout << "Intersection of Set 1 and Set 2: ";
			toString(intersectionSet);
			nonADTMenu();
			cin >> input;
		}
		else if (input == "d") {
			vector<int> differenceSet = nonADTSet1 - nonADTSet2;
			cout << "Difference of Set 1 and Set 2: ";
			toString(differenceSet);
			nonADTMenu();
			cin >> input;
		}
		else {
			cout << "That is not a valid command." << endl;
			nonADTMenu();
			cin >> input;
		}
	}
	cout << "Exiting the program." << endl;











	return 0;
}

/**
 * This function performs union between two sets (vectors)
 */
vector<int> operator+(const vector<int>& set1, const vector<int>& set2) {
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
	for (int i = 0; i < set1.size(); i++) {
		output.push_back(set1[i]);
	}
	for (int i = 0; i < set2.size(); i++) {
		vector<int>::iterator vectorPosition = find(output.begin(), output.end(), set2[i]);
		if (vectorPosition != output.end()) {
			output.erase(vectorPosition);
		}
		else {
			output.push_back(set2[i]);
		}
	}
}

/**
 * This function prints out the vector/set.
 */
void toString(vector<int>& v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v.back() << "]" << endl;
}

/**
 * This function prints the non-ADT menu.
 */
void nonADTMenu() {
	cout << "What would you like to do with your sets?" << endl;
	cout << "\"u\" : perform union between the two sets" << endl;
	cout << "\"i\" : perform intersection between the two sets" << endl;
	cout << "\"d\" : perform difference between the two sets" << endl;
	cout << "\"e\" : exit this program" << endl;
}




