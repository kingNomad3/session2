#include <iostream>
#include <fstream>

const int MAX = 150;

using namespace std;

struct Date_s {
	int Annee, Mois, Jour;
};

struct Contact_s {
	char Nom[MAX], Prenom[MAX];
	Date_s DateNaissance;
	long Telephone;
};

void Ecrire(std::string Fname) {
	Contact_s contact;

	std::cout << "Nom du contact; ";
	std::cin.getline(contact.Nom, MAX);
	std::cout << "Prenom du contact: ";
	std::cin.getline(contact.Prenom, MAX);
	std::cout << "Telephone du contact";
	std::cin >> contact.Telephone;
	std::cout << "date de naissance (dd mm aaaa) : ";
	std::cin >> contact.DateNaissance.Jour >> contact.DateNaissance.Mois >> contact.DateNaissance.Annee;

	std::fstream Fichier;
	Fichier.open(Fname, std::ios::app | std::ios::binary);
	Fichier.write((char*)&contact, sizeof(Contact_s));
	Fichier.close();
	std::cin.ignore(); std::cin.clear;


}

void AfficherTout(std::string fname) {
	Contact_s contact;
	int id = 1;

	std::fstream Fichier;
	Fichier.open(fname, std::ios::in| ios::binary);
	cout << left << set(5)<< "ID"
		<< left << setw(MAX + 1) << "Nom"
		<< left << setw(MAX + 1) << "Prenom"
		<< left << setw(11) << "Telephone"
		<< left << setw(10) << "Date de naissance\n";
	for (size_t i = 0; i < 2 * MAX + 35; i++) {
		cout << "-"; 
	}
}