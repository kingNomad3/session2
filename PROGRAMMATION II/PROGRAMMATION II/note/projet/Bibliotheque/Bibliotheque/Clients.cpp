#include "flux_io.h"
#include "type.h"
#include "utils.h"
#include "cvm23.h"
#include <fstream>
#include <cstring>

const std::string FILENAME_CLIENT = "Clients.bin";





void NouveauClient() {
	Client_s client = {};
	setcp(1252);
	std::fstream fichierClient;

	fichierClient.open(FILENAME_CLIENT, std::ios::app | std::ios::binary);

	std::cout << std::endl;
	ecrire << "Nom du client : ";
	LireChaineC(client.Nom, MAX_CHAR);
	ecrire << "Prenom du client : ";
	LireChaineC(client.Prenom, MAX_CHAR);
	ecrire << "Téléphone du client : ";
	LireChaineC(client.Telephone, 11);
	ecrire << "Numéro civique du client : ";
	lire >> client.Adresse.NumCivil; //std::cin
	io_clean();

	ecrire << "Rue du client : ";
	LireChaineC(client.Adresse.Rue, MAX_CHAR);
	ecrire << "Ville du client : ";
	LireChaineC(client.Adresse.Ville, MAX_CHAR);
	ecrire << "Code postal du client (format X0X0X0) : ";
	LireChaineC(client.Adresse.CodePostal, 7);

	client.DateInscription = Aujourdhui();

	for (int i = 0; i < 3; i++) {
		client.Prets[i].NumLivre = -1 ;
	}

	fichierClient.write((char*)&client, sizeof(Client_s));
	fichierClient.close();
}

Client_s RechercherDossierClient(int id) {
	Client_s client = {};
	std::ifstream fichierClient(FILENAME_CLIENT, std::ios::binary);
	
	fichierClient.seekg(sizeof(Client_s) * id, std::ios::beg);
	fichierClient.read((char*)&client, sizeof(Client_s));
	fichierClient.close();

	return client;
}

void AfficherDossierClient(int id) {
	
	Client_s client = RechercherDossierClient(id);

	if(strlen(client.Nom) == 0) {
		ecrire << "Ce client n'existe pas";
	}
	else {
		ecrire << "ID du client : " << id << std::endl;
		ecrire << "Nom du client : " << client.Nom << std::endl;
		ecrire << "Prénom du client : " << client.Prenom << std::endl;
		ecrire << "Téléphone du client : " << client.Telephone << std::endl;
		ecrire << "Adresse du client : " << client.Adresse.NumCivil << " " << client.Adresse.Rue << ", " << client.Adresse.Ville << " (" << client.Adresse.CodePostal << ")" << std::endl;
		ecrire << "Nombre de livre prêté : " << client.NombrePretActif << std::endl;
	}
}

void MiseAJourClient(int id, Client_s client){
	std::fstream fichierClient;

	fichierClient.open(FILENAME_CLIENT, std::ios::in | std::ios::out | std::ios::binary);
	fichierClient.seekp(sizeof(Client_s) * id, std::ios::beg);
	fichierClient.write((char*)&client, sizeof(Client_s));

	fichierClient.close();
}

void ListeDesClientsEnRetard() {
	Client_s client = {};
	Pret_s pret = {};
	int compteur = 0;

	std::fstream fichierClient;
	fichierClient.open(FILENAME_CLIENT, std::ios::in | std::ios::binary);

	ecrire << "Nom (Téléphone) : Date de retour prévu" << std::endl;
	ecrire << "----------" << std::endl;

	while (!fichierClient.eof()) {
		fichierClient.seekp(compteur * sizeof(Client_s), std::ios::beg);
		fichierClient.read((char*)&client, sizeof(Client_s));

		for (int i = 0; i < 3; i++) {
			if(client.Prets[i].NumLivre !=-1){
			if ((client.Prets[i].DateRetourPrevu.mois * 12 + client.Prets[i].DateRetourPrevu.jour) < (Aujourdhui().mois * 12 + Aujourdhui().jour))
				ecrire << client.Prenom << " " << client.Nom << " " << "(" << client.Telephone << ")" << " : " << client.Prets[i].DateRetourPrevu.jour << "/" << client.Prets[i].DateRetourPrevu.mois << "/" << client.Prets[i].DateRetourPrevu.annee;
			}
		}
		compteur++;
	}
	fichierClient.close();
}

void RechercherClientMain() {
	int id = 0;
	gotoxy(0, 15);
	ecrire << "Entrez le numéro de la personne à rechercher :";
	lire >> id;
	void io_clean();
	RechercherDossierClient(id);
	AfficherDossierClient(id);
}

