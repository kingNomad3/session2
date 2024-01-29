#include <iostream>
#include <conio.h>
#include "..\cvm23.h"

using namespace std; 


//char enumaration;



//enum operation_e {
//
//	a, s, m, d
//
//
//};




//double operation(double a, double b, operation_e op) {
//	double rep = 0;
//
//	switch (op)
//	{
//	case '*':
//		rep = a * b;
//		break;
//	case '/':
//		rep = a / b;
//		break;
//	case '+':
//		rep = a + b;
//		break;
//	case '-':
//		rep = a - b;
//		break;
//	}
//	return rep;
//
//};



string MotPlusHautScore(string tableauMots[], int Lettre) {
	int Position = -1, Max = 0, HautScore;
	for (int i = 0; i < Lettre; i++)
	{
		if (tableauMots[i].length() > Max) {
			Position = i;
			Max = tableauMots[i].length();


		}
	}
	HautScore = HautScore + Position;
	return HautScore;
}

int main() {
	
	cout << ;
	
	_getch();
}
