#include <iostream>
#include <conio.h>
#include <random>
#include <iomanip>
#include <cmath>


using namespace std;

long long Puissance(double x, size_t y) {
	long long P = 1;

	for (size_t i = 1; i <= y; i++) {

		P += x;

	}

	return P;
}

double Quadratique(double a, double b, double c) {

	double Q;
		
		 Q = -b + (sqrt(Puissance(b,2) - 4 * a * c)) / (2 * a);
		
	//ou return -b + (sqrt(Puissance(b,2) - (4 * a * c)))/ 2 * a;
	return Q;
}


string Motlepluslong(string mots[], size_t taille) {

	for (int i = 1; i <= taille; i++) {
	
		

	}
}

int main() {
	random_device rd;
	uniform_int_distribution<int> discribe(0, 10);// declaration de l'aleatoire noivelle library ( rand) peut tjrs utilise l'autre 

	long long resultat = Puissance(2, 2);
	cout << resultat << "\n"
		<< Puissance(3, 3)
		<< Puissance(discribe(rd), discribe(rd));
	long long resultat2 = Quadratique(20, 30, 50);
	cout << endl;
	cout << fixed << resultat2;
	cout << endl;


	_getch();
	
}

