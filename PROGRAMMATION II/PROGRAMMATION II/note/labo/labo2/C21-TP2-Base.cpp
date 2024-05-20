#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>
#include <windows.h>

#include "cvm23.h"

using namespace std;


const size_t CLIENTS_MAX = 70;						// nombre maximal de clients
const size_t COMPTES_MAX = 3;						// nombre de comptes par client

const double MARGE_CREDIT_MAX = 10000;				// marge de cr�dit maximun d'un compte du client
const double SOLDE_COMPTE_MAX = 1000000;			// maximun � ne pas d�passer dans un compte d'un client

const float PART_SOCIALE = 15.f;					// Valeur de la part sociale

enum class Commandes { ajouter, quitter, inconnue };// � COMPL�TER AVEC LES AUTRES COMMANDES ...
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

struct PersonneCliente								// informations relatives � un client
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
/* LES D�CLARATIONS (PROTOTYPES) DE FONCTIONS */
/* ------------------------------------------ */

void io_bip();
void io_clean();
double io_round(double v, size_t p = 2);			// par defaut la pr�cision est � deux d�cimales (p = 2)

/*
	Suggestion de fonctions:

	size_t lireNoClientValide(size_t maxno);
	size_t lireNoCompteValide();
	double lireMontantValide(double maxmontant);
	void afficherComptesClient(Client& client);
*/

// �crire ici toutes vos d�clarations de fonctions ...
// ...



/* ------------------------------------- */
/* FONCTIONS TR�S G�N�RALES DU PROGRAMME */
/* ------------------------------------- */

void io_bip() { Beep(200, 300); }

void io_clean()										// pour vider les 2 tampons
{
	cin.clear();									// s'assure que le cin est remis en marche
	cin.ignore(cin.rdbuf()->in_avail());			// vide le tampon du cin
	while (_kbhit()) (void)_getch();				// vide le tampon de la console
}

double io_round(double v, size_t p)					// valeur et pr�cision
{
	double e = pow(10, p);
	return round(v * e) / e;
}


/* ----------------------------------------------------------------------- */
/* FONCTIONS G�N�RALES POUR L'INTERFACE USAGER (UI) EN LECTURE OU �CRITURE */
/* ----------------------------------------------------------------------- */

void afficherMenu()
{
	// afficher le menu ...
}

Commandes lireChoixMenu()
{ 
	Commandes cmd = Cmd::quitter;					// commande par d�faut

	// lire la commande et la retourner � main ...

	return cmd;
}

/* ------------------------------------------------------------ */
/* LES FONCTIONS OBLIGATOIRES POUR CHAQUE COMMANDE DU PROGRAMME */
/* ------------------------------------------------------------ */

void AjouterPersCliente( /* Param�tre ? indice: doit avoir acc�s � la variable bk de main */ )
{
	// �crire le code ici ...
}

void AfficherPersCliente( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void Deposer( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void Retirer( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void Virer( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void ListePersClientes( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void Supprimer( /* Param�tres ? */ )
{
	// �crire le code ici ...
}

void Quitter( /* Param�tres ? */)
{
	// �crire le code ici ...
}

/* ---------------------- */
/* LA FONCTION PRINCIPALE */
/* ---------------------- */

int main()
{
	setcp(1252);
	cout << fixed << setprecision(2);

	Cmd cmd = Cmd::inconnue;

	Banque& b = *new Banque;	// cr�ation dynamique d'une Banque

	do
	{
		afficherMenu();
		cmd = lireChoixMenu();
		
		switch (cmd)
		{
			case Cmd::ajouter: AjouterPersCliente( /* AjouterPersCliente doit avoir acc�s � la variable bk de main */ ); break;
			
			//...

			case Cmd::quitter: Quitter(); break;
		}

	} while(cmd != Cmd::quitter);

	delete &b;
}