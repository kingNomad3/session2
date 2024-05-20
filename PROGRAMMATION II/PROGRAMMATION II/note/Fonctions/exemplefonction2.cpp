#include <iostream>
#include <iomanip>
#include <conio.h>
using namespace std;

// Structures s'il y en a
enum Operation_e { Plus, Moins, Mult, Div };

string TrouverPlusHautScore(string[], int);
double Operation(double a, double b, Operation_e op);

void main(void) {
	string tab[3] = { "a", "ab", "abc" };
	cout << TrouverPlusHautScore(tab, 3) << "\n";
	cout << "2 * 3 = " << Operation(2, 3, Mult);
	_getch();
}

string TrouverPlusHautScore(string tableauMots[], int nbreMots) {
	int Position = -1, Max = 0;
	int ScoreLettre[26] = {
		1, 2, 3, 5, 44, 89, 56, 8, 6, 3, 5, 2, 5,
		78, 94, 85, 68, 98, 45, 5, 65, 7, 5, 2, 100, 2
	};

	for (int i = 0; i < nbreMots; i++)
	{
		int Score = 0;
		for (int j = 0; j < tableauMots[i].length(); j++)
		{
			if (isalpha(tableauMots[i].at(j))) {
				char Lettre = toupper(tableauMots[i].at(j));
				Score += ScoreLettre[Lettre - 65];
			}
		}

		if (Score > Max) {
			Max = Score;
			Position = i;
		}
	}

	if (Position > -1)
		return tableauMots[Position];
	else
		return "";
}

double Operation(double a, double b, Operation_e op) {
	switch (op)
	{
	case Plus:
		return a + b;
	case Moins:
		return a - b;
	case Mult:
		return a * b;
	case Div:
	default:
		return a / b;
	}
}