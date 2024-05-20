#include <iostream>
#include <conio.h>
using namespace std;

struct PersonneEtudiante_s {
	string Nom;
	string Prenom;
	int Matricule;
	string Telephone;
	float MoyenneGenerale;
};

void main(void) {
	/*************************
	* SANS STRUCTURE
	**************************/
	string Nom = "Borduas", Prenom = "Godefroy";
	int Matricule = 2021;
	float MoyenneGenerale = 42;
	string Telephone = "5797214447";

	bool Quitter = false;

	while (!Quitter)
	{
		cout << "\nVotre personne \202tudiante :"
			<< "\n\tNom : " << Nom
			<< "\n\tPrenom : " << Prenom
			<< "\n\tMatricule : " << Matricule
			<< "\n\tMoyenne Generale : " << MoyenneGenerale
			<< "\n\tTelephone : " << Telephone;

		cout << "\n\nMenu:\n\t1. Modifier le num\202ro de t\202l\202phone"
			<< "\n\t2. Modifier la moyenne g\202r\202nale"
			<< "\n\t3. Fermer l'application\nVotre choix : ";
		switch (_getche())
		{
		case '1':
			cout << "\nNouveau num\202ro de t\202l\202hpone : ";
			cin >> Telephone;
			break;
		case '2':
			cout << "\nNouvelle moyenne g\202n\202rale : ";
			cin >> MoyenneGenerale;
			break;
		default:
			Quitter = true;
			break;
		}
	}

	/*************************
	* AVEC STRUCTURE
	**************************/
	PersonneEtudiante_s etu;

	etu.Nom = "Borduas", etu.Prenom = "Godefroy", etu.Matricule = 2021;
	etu.Telephone = "579 721-4447";
	etu.MoyenneGenerale = 42;

	cout << etu.Nom;
	cout << etu.Prenom;

	Quitter = false;

	while (!Quitter)
	{
		cout << "\nVotre personne \202tudiante :"
			<< "\n\tNom : " << etu.Nom
			<< "\n\tPrenom : " << etu.Prenom
			<< "\n\tMatricule : " << etu.Matricule
			<< "\n\tMoyenne Generale : " << etu.MoyenneGenerale
			<< "\n\tTelephone : " << etu.Telephone;

		cout << "\n\nMenu:\n\t1. Modifier le num\202ro de t\202l\202phone"
			<< "\n\t2. Modifier la moyenne g\202r\202nale"
			<< "\n\t3. Fermer l'application\nVotre choix : ";
		switch (_getche())
		{
		case '1':
			cout << "\nNouveau num\202ro de t\202l\202hpone : ";
			cin >> etu.Telephone;
			break;
		case '2':
			cout << "\nNouvelle moyenne g\202n\202rale : ";
			cin >> etu.MoyenneGenerale;
			break;
		default:
			Quitter = true;
			break;
		}
	}
}