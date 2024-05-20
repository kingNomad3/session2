#include <iostream>
#include <iomanip>
#include <conio.h>
#include <random>
#include <cstdlib>
#include <cmath>

using namespace std;

long long Puissance(int x, size_t y) {
	long long P = 1;
	for (size_t i = 1; i <= y; i++)
	{
		P *= x;
	}

	return P;
}

double Quadratique(double a, double b, double c) {
	/*double x = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
	return x;*/

	return (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
}

string MotPlusLong(string tableauMots[], int nbreMots) {
	int Position = -1, Max = 0;
	for (int i = 0; i < nbreMots; i++)
	{
		if (tableauMots[i].length() > Max) {
			Position = i;
			Max = tableauMots[i].length();
		}
	}

	if (Position > -1)
		return tableauMots[Position];
	else
		return "";
}

int main() {
	random_device rd;
	uniform_int_distribution<int> distrib(0, 10);

	long long resultat = Puissance(2, 2);
	cout << resultat << "\n"
		<< Puissance(3, 3) << "\n"
		<< Puissance(distrib(rd), distrib(rd)) << "\n"
		<< fixed << Quadratique(-5, 0.3, 5) << "\n";

	string mots[5] = { "Fraise", "Banane", "Pomme", "Kiwi", "Pomme de terre" }, patate[5];
	cout << "Mot le plus long : " << MotPlusLong(mots, 5);
}