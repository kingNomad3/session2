#include <iostream>
#include <cmath>
using namespace std;

struct Identification_s
{
	string Nom;
	string Prenom;
};

struct PersonneEtudiante_s {
	Identification_s identification;
	int Matricule;
	string Telephone;
	float MoyenneGenerale;
};

void main(void) {
	PersonneEtudiante_s etu = { {"Borduas", "Godefroy"}, 2021, "5797214447", 42};

	cout << etu.identification.Nom;
}