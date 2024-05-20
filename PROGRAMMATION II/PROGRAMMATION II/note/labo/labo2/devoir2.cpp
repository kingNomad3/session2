#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>
#include <windows.h>

#include "../cvm23.h"

using namespace std;


const size_t CLIENTS_MAX = 70;						// nombre maximal de clients
const size_t COMPTES_MAX = 3;						// nombre de comptes par client

const double MARGE_CREDIT_MAX = 10000;				// marge de crédit maximun d'un compte du client
const double SOLDE_COMPTE_MAX = 1000000;			// maximun à ne pas dépasser dans un compte d'un client

const float PART_SOCIALE = 15.f;					// Valeur de la part sociale


const int MAX_NUMB = 9;
const string BANQUE = "Banque CVM";
const string SUCC = " Sucursale C21";
const string AFF_CHOIX1 = "1 - Ajouter une personne cliente";
const string AFF_CHOIX2 = "2 - Afficher toutes les informations d’une personne cliente ";
const string AFF_CHOIX3 = "3 - Dépôt";
const string AFF_CHOIX4 = "4 - Retrait";
const string AFF_CHOIX5 = "5 - Virement";
const string AFF_CHOIX6 = "6 - Afficher toutes les personnes clientes et leur crédit actuel";
const string AFF_CHOIX7 = "7 - Suppression d'une personne cliente";
const string AFF_CHOIXQ = "Q - Quitter l'application";
const string AFF_CHOIX = "Votre choix : ";
const string MESSAGE_ERR = "Cette option est invalide. Veillez choisir l'une des options disponibles. \n Appuyez sur une touche pour continuer. ";
const string MESS_AJNOM = " Ajouter une personne cliente ";
const string DOUB_LIGNE = " ============================";
const string MESS_NOM = "Nom de la personne cliente : ";
const string MESS_PRE = "Nom de la personne cliente : ";
const string MESS_NAS = "NAS de la personne cliente : ";
const string MESS_TEL = "Téléphone de la personne cliente :";
const string MESS_CIV = "Numero civil de la personne cliente :";
const string MESS_RUE = "Numero civil de la personne cliente :";
const string MESS_VILLE = "Ville de la personne cliente";
const string MESS_POST = "Code postal de la personne cliente :";
const string ERR_NAS = "La valeur entrée n'est pas valide. Un NAS est composé de 9 chiffres.";
const string MESS_MARGECREDIT1 = "Entrez la marge de crédit du compte 1 :";
const string MESS_MARGECREDIT2 = "Entrez la marge de crédit du compte 2 :";
const string MESS_MARGECREDIT3 = "Entrez la marge de crédit du compte 3 :";
const string TRAITEMENT = "Traitement en cours";
const string TRAITEMENT_TER = "Traitement termine";
const string APPUYEZ = "Appuyer sur une touche pour continuer";

enum class Commandes { ajouter, afficher, depot, retrait, virement, afficherPetC, supprimer, quitter, inconnue };// À COMPLÉTER AVEC LES AUTRES COMMANDES ...
using Cmd = Commandes;



struct Nom											// nom d'un client
{
	string prenom;
	string nom;
};


struct Adresse										// adresse d'un client
{
	string noCivique;
	string rue;
	string ville;
	string codePostal;
};

struct Personne										// informations personnelles d'un client
{
	Nom		nom;
	Adresse	adresse;
	string	telephone;
	string	nas;
};

struct Compte										// un compte d'un client
{
	double solde;
	double margeCredit;
};

struct PersonneCliente								// informations relatives à un client
{
	Personne	info;
	Compte		comptes[COMPTES_MAX];
	time_t		date;								// date d'ajout du client
	float		partSociale;						// Montant de la part sociale fournit
};

struct Banque										// La banque de clients
{
	size_t cpt = 0;									// cpt: compteur de client [0..CLIENTS_MAX]
	PersonneCliente clients[CLIENTS_MAX];
};

/* ----------------------------------- */
/* LES VARIABLES GLOBALES DU PROGRAMME */
/* ----------------------------------- */

// ATTENTION: les variables globales ne sont pas permises dans ce TP




/* ------------------------------------------ */
/* LES DÉCLARATIONS (PROTOTYPES) DE FONCTIONS */
/* ------------------------------------------ */



void io_bip();
void io_clean();
double io_round(double v, size_t p = 2);			// par defaut la précision est à deux décimales (p = 2)

/*
	Suggestion de fonctions:

	size_t lireNoClientValide(size_t maxno);
	size_t lireNoCompteValide();
	double lireMontantValide(double maxmontant);
	void afficherComptesClient(Client& client);
*/

// écrire ici toutes vos déclarations de fonctions ...
// ...



/* ------------------------------------- */
/* FONCTIONS TRÈS GÉNÉRALES DU PROGRAMME */
/* ------------------------------------- */

void io_bip() { Beep(200, 300); }

void io_clean()										// pour vider les 2 tampons
{
	cin.clear();									// s'assure que le cin est remis en marche
	cin.ignore(cin.rdbuf()->in_avail());			// vide le tampon du cin
	while (_kbhit()) (void)_getch();				// vide le tampon de la console
}

double io_round(double v, size_t p)					// valeur et précision
{
	double e = pow(10, p);
	return round(v * e) / e;
}

//setcp1252();
/* ----------------------------------------------------------------------- */
/* FONCTIONS GÉNÉRALES POUR L'INTERFACE USAGER (UI) EN LECTURE OU ÉCRITURE */
/* ----------------------------------------------------------------------- */

void afficherMenu()
{
	const int x = 10;
	const int y = 5;
	// afficher le menu ...
	setcolor(Color::blu);
	gotoxy(x, y);
	cout << setw(x) << " " << BANQUE;  setcolor(Color::yel); cout << " " << SUCC << endl;
	setcolor(Color::wht); cout << setw(x) << " " << AFF_CHOIX1 << endl;
	cout << setw(x) << " " << AFF_CHOIX2 << endl;
	cout << setw(x) << " " << AFF_CHOIX3 << endl;
	cout << setw(x) << " " << AFF_CHOIX4 << endl;
	cout << setw(x) << " " << AFF_CHOIX5 << endl;
	cout << setw(x) << " " << AFF_CHOIX6 << endl;
	cout << setw(x) << " " << AFF_CHOIX7 << endl;
	cout << setw(x) << " " << AFF_CHOIXQ << endl;
	cout << setw(x) << " " << AFF_CHOIX;

}

Commandes lireChoixMenu()
{
	Commandes cmd = Cmd::quitter;	// commande par défaut

	char choix;
	cin >> choix;

	switch (choix)
	{
	case '1':
		cmd = Cmd::ajouter;
		break;
	case '2':
		cmd = Cmd::afficher;
	case '3':
		cmd = Cmd::depot;
	case '4':
		cmd = Cmd::retrait;
	case '5':
		cmd = Cmd::virement;
	case '6':
		cmd = Cmd::afficherPetC;
	case '7':
		cmd = Cmd::supprimer;
	}

	return cmd;
}

/* ------------------------------------------------------------ */
/* LES FONCTIONS OBLIGATOIRES POUR CHAQUE COMMANDE DU PROGRAMME */
/* ------------------------------------------------------------ */

string infonom() {
	string nom;
	string prenom;
	setcolor(Color::blu); cout << MESS_AJNOM + "\n" + DOUB_LIGNE << endl;
	setcolor(Color::wht); cout << MESS_NOM;
	cin >> nom; cout << endl;
	cout << MESS_PRE;
	cin >> prenom; cout << endl;
	cout << MESS_NAS;

	return nom;
	return prenom;
}


string VerificationNas() {
	bool valide = false;
	string nas;

	

	while (!valide) {
		cout << "Please enter 9 digits: ";
		cin >> nas;

		if (nas.length() != 9) {
			cout << MESSAGE_ERR << endl;
			continue; // Go back to the start of the loop
		}

		bool allDigits = true;
		for (char c : nas) {
			if (!isdigit(c)) {
				allDigits = false;
				break;
			}
		}

		if (!allDigits) {
			cout <<  MESSAGE_ERR << endl;
			continue;
		}

		valide = true; 
	}

	
	cout << "Le nass est " << nas << endl;
	return nas;
}

string VerificationPost() {

	bool valide = false;
	string post;

	while (!valide) {
		cout << MESSAGE_ERR<< endl;
		cin >> post;

		if (post.length() != 6) {
			cout << MESSAGE_ERR << endl;
			continue; 
		}

		bool FormatValide = true;
		for (int i = 0; i < 6; i++) {
			char c = post[i];
			if (i % 2 == 0) {
				if (!isalpha(c)) {
					FormatValide = false;
					break;
				}
			}
			else {
				if (!isdigit(c)) {
					FormatValide = false;
					break;
				}
			}
		}

		if (!FormatValide) {
			cout << MESSAGE_ERR << endl;
			continue; 
		}

		valide = true; 
	}

	cout << post << endl;
	return post;
}

string VerificationTel() {
	bool valide = false;
	string telephone;

	while (!valide) {
		
		cin >> telephone;

		if (telephone.length() != 7) {
			
			continue; 
		}

		bool Digits = true;
		for (char c : telephone) {
			if (!isdigit(c)) {
				Digits = false;
				break;
			}
		}

		if (!Digits) {
			cout << MESSAGE_ERR << endl;
			continue; 
		}

		valide = true; 
	}

	
	return telephone;
}






float ajouterinfocredit(float CreditC1) {
	/*int x = 10;
	int y = 5;*/
	//float CreditC1;
	float CreditC2;
	float CreditC3;




	cout << MESS_MARGECREDIT1;
	cin >> CreditC1;
	cout << MESS_MARGECREDIT2;
	cin >> CreditC2;
	cout << MESS_MARGECREDIT3;
	cin >> CreditC3;
	int x = wherex();
	int y = wherey();
	setcolor(Color::yel); cout << TRAITEMENT; Sleep(1000); cout << "."; Sleep(400); cout << "."; Sleep(500); cout << ".";
	gotoxy(x, y); clreoscr(); setcolor(Color::grn); cout << TRAITEMENT_TER << endl; cout << APPUYEZ; cout << MESS_MARGECREDIT1;

	return CreditC1;
	return CreditC2;
	return CreditC3;

}

void AjouterPersCliente(Banque& b)
{
	clrscr();

	string Civil;
	string Rue;
	string Ville;
	string Post;

	int Tel;

	infonom();
	VerificationNas();
	

	cout << MESS_TEL;
	cin >> Tel;
	cout << MESS_CIV;
	cin >> Civil;
	cout << MESS_RUE;
	cin >> Rue;
	cout << MESS_VILLE;
	cin >> Ville;
	cout << MESS_POST;
	cin >> Post;
	ajouterinfocredit();

}

void AfficherPersCliente(Banque& b/* Paramètres ? */)
{
	// Écrire le code ici ...
}

void Deposer(Banque& b /* Paramètres ? */)
{
	// Écrire le code ici ...
}

void Retirer(Banque& b/* Paramètres ? */)
{
	// Écrire le code ici ...
}

void Virer(Banque& b /* Paramètres ? */)
{
	// Écrire le code ici ...
}

void ListePersClientes(Banque& b /* Paramètres ? */)
{
	// Écrire le code ici ...
}

void Supprimer(Banque& b /* Paramètres ? */)
{
	// Écrire le code ici ...
}

void Quitter(Banque& b/* Paramètres ? */)
{
	// Écrire le code ici ...
}

/* ---------------------- */
/* LA FONCTION PRINCIPALE */
/* ---------------------- */

int main()
{
	setcp(1252);
	cout << fixed << setprecision(2);


	Cmd cmd = Cmd::inconnue;

	Banque& b = *new Banque;	// création dynamique d'une Banque


	do
	{

		afficherMenu();

		cmd = lireChoixMenu();

		switch (cmd)
		{
		case Cmd::ajouter: AjouterPersCliente(b);/* AjouterPersCliente doit avoir accès à la variable b de main */

			break;
		case Cmd::afficher:AfficherPersCliente(b);
			break;
		case Cmd::depot:Deposer(b);
			break;
		case Cmd::retrait:Retirer(b);
			break;
		case Cmd::virement:Virer(b);
			break;
		case Cmd::afficherPetC:ListePersClientes(b);
			break;
		case Cmd::supprimer:Supprimer(b);
			break;


		case Cmd::quitter: Quitter(b); break;
		}

	} while (cmd != Cmd::quitter);

	delete& b;
}

//https://www.educative.io/answers/what-is-string-erase-in-cpp pour le code postal