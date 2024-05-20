#pragma once
#include "flux_io.h"

//CORRIGE : Bonne place?
extern const std::string FILENAME_LIVRE;
extern const std::string FILENAME_CLIENT;

static const int MAX_CHAR = 125;


struct Date_s {
    int jour, mois, annee,
        heure, minute, seconde;
};

struct Livre_s
{
    char Titre[MAX_CHAR];
    char Auteur[MAX_CHAR];
    bool Loue;
	
};


struct Pret_s {
	int NumLivre;
	Date_s DateLocation;
	Date_s DateRetourPrevu;
	
};


struct Adresse_s {
	int NumCivil;
	char Rue[MAX_CHAR];
	char Ville[MAX_CHAR];
	char CodePostal[7]; 
};


struct Client_s
{
	
	char Nom[MAX_CHAR];
	char Prenom[MAX_CHAR];
	char Telephone[11];
	Adresse_s Adresse;
	Date_s DateInscription;
	int NombrePretActif;
	Pret_s Prets[3];
	
};

