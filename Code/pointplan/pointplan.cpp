#include <iostream>
#include <conio.h>
#include "..\cvm 21.h"
#include <math.h>
using namespace std;

	
	
	
	

struct Graphique_s {
	float x1;
	double x2;
	double y1;
	double y2;
	double reponse;
};

int main() {
	float Ux1;
	float Ux2;
	float Uy1;
	float Uy2;
	double Urep=0;
	
	Graphique_s X;
	Graphique_s Y;
	Graphique_s Rep;

	X.x1 = Ux1=0;
	X.x2 = Ux2=0;
	Y.y1 = Ux1=0;
	Y.y2 = Ux2=0;
	Rep.reponse = Urep;
	
	
	

	cout << "entrer les points du plan cartesien" << endl;
	cout << "X1:\t"; cin >> Ux1; cout << endl;
	cout << "X2:\t"; cin >> Ux2; cout << endl;
	cout << "y1:\t"; cin >> Uy1; cout << endl;
	cout << "y2:\t"; cin >> Uy2; cout << endl;

	

	Rep.reponse = sqrt(pow(Ux2 - Ux1,2) + pow(Uy2 - Uy1,2));

	cout << "La distance entre les deux points est : " <<  Rep.reponse;







}
