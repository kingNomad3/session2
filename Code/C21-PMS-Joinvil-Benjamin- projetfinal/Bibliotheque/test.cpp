// Ne modifiez pas ce fichier
#ifdef __CORRECTION__
#include <cstdio>
#include <cmath>
#include <iostream>
#include <fstream>
#include <conio.h>
#include "cvm23.h"
#include "test.h"
#include "flux_io.h"
#include "Livres.h"
#include "Clients.h"
#include "Location.h"
#include "utils.h"
#include <chrono>
#include <thread>


#include <cstdio>

const std::string CORRECTION_FILENAME = "grille.csv";
const char DELIMITER = ';';
static int nbResult;
static int Total;

static std::stringstream resultCorrection;

static void sleep(int delay = 1) {
	std::this_thread::sleep_for(std::chrono::milliseconds(delay * 1000));
}

static void DeleteFiles() {
	remove(FILENAME_CLIENT.c_str());
	remove(FILENAME_LIVRE.c_str());
}

static float roundUp(float toRound) {
	float t = toRound * 100;
	float c = ceil(t);
	return c / 100;
}

static void CreateCorrectionFile() {
	nbResult = 0;
	Total = 0;
	std::fstream Fichier;
	Fichier.open(CORRECTION_FILENAME, std::ios::out);

	Fichier << "Ajout au fichier de Livre (/1)"
		<< DELIMITER << "Ajout unique dans NouveauLivre (/1)"
		<< DELIMITER << "Ajout au fichier de Client (/1)"
		<< DELIMITER << "Ajout unique dans NouveauClient (/1)"
		<< DELIMITER << "Recherche de livre (/4)"
		<< DELIMITER << "Recherche de client (/4)"
		<< DELIMITER << "Mise à jour d'un livre (/1)"
		<< DELIMITER << "Mise à jour d'un client (/1)"
		<< DELIMITER << "Location d'un livre (/5)"
		<< DELIMITER << "Retour d'un livre (/11)"
		<< DELIMITER << "Affichage d'un livre (/5)"
		<< DELIMITER << "Affichage d'un client (/10)"
		<< DELIMITER << "Affichage de la liste des livres prêté (/2)"
		<< DELIMITER << "Affichage de la liste des clients en retard (/3)"
		<< DELIMITER << "Total (/50)"
		<< "\n";

	Fichier.close();
}

static void CloseCorrection() {
	std::fstream Fichier;
	Fichier.open(CORRECTION_FILENAME, std::ios::app);

	Fichier << DELIMITER << Total;
	resultCorrection << "\n\nTotal de l'évaluation : " << Total << "/50\n";

	Fichier.close();

	if (globalFileName != "--null") {
		std::string studentResultLine = "";
		// Récupération des résultats d'évaluation
		std::fstream Fichier;
		Fichier.open(CORRECTION_FILENAME, std::ios::in);
		std::getline(Fichier, studentResultLine);
		std::getline(Fichier, studentResultLine);
		Fichier.close();
		// Ajout à la feuille d'évaluation globale
		Fichier.open(globalFileName, std::ios::app);

		Fichier << MATRICULE << DELIMITER << NOM_ETUDIANT_E << DELIMITER << PRENOM_ETUDIANT_E
			<< studentResultLine << "\n";

		Fichier.close();
	}
}

static void AjoutPoint(int pointage) {
	std::fstream Fichier;
	Fichier.open(CORRECTION_FILENAME, std::ios::app);

	if (nbResult > 0)
		Fichier << DELIMITER;
	Fichier << pointage;
	resultCorrection << pointage;
	nbResult++;
	Total += pointage;

	Fichier.close();
}

static void SetFlux() {
	ecrire.clear();
	ecrire.str("");
	lire.clear();
}

static void TestNouveauLivre() {
	resultCorrection << "Test de la fonction NouveauLivre :\n";
	remove(FILENAME_LIVRE.c_str());
	std::string Titre = "Un guide galactique";
	std::string Auteur = "Douglas Adam";
	lire << Titre << "\n" << Auteur;
	NouveauLivre();

	std::fstream Fichier;
	Fichier.open(FILENAME_LIVRE, std::ios::in | std::ios::binary);

	// Parcourir tout le fichier -> doit posséder une seule entrée
	Livre_s resultLivre = {};
	Livre_s test = { "Un guide galactique", "Douglas Adam", false };

	resultCorrection << "\tAjout du livre {" << test.Titre << ", " << test.Auteur << "} : ";
	Fichier.read((char*)&resultLivre, sizeof(Livre_s));
	if (LivreEquals(resultLivre, test))
		AjoutPoint(1);
	else
		AjoutPoint(0);

	resultCorrection << "/1\n";

	resultLivre = {};
	resultCorrection << "\tAjout unique d'un livre : ";
	Fichier.read((char*)&resultLivre, sizeof(Livre_s));
	if (Fichier.eof() && LivreEquals(resultLivre, {}))
		AjoutPoint(1);
	else
		AjoutPoint(0);
	resultCorrection << "/1\n";

	Fichier.close();
}

static void TestNouveauClient() {
	resultCorrection << "\n\nTest de la fonction NouveauClient :\n";
	remove(FILENAME_CLIENT.c_str());
	lire << "Gutenberg\nJohannes\n"
		<< "22101454\n" << 1455
		<< " De la Bible\nAllemagne\nC1C1C1";
	NouveauClient();

	std::fstream Fichier;
	Fichier.open(FILENAME_CLIENT, std::ios::in | std::ios::binary);

	// Parcourir tout le fichier -> doit posséder une seule entrée
	Client_s result = {};
	Client_s test = { "Gutenberg", "Johannes", "22101454", { 1455, "De la Bible", "Allemagne", "C1C1C1" }, Aujourdhui(), 0, { { -1, {}, {} }, { -1, {}, {} }, { -1, {}, {} } } };

	resultCorrection << "\tAjout du client {Gutenberg, Johannes} : ";
	Fichier.read((char*)&result, sizeof(Client_s));
	if (ClientEquals(result, test))
		AjoutPoint(1);
	else
		AjoutPoint(0);
	resultCorrection << "/1\n";

	resultCorrection << "\tAjout unique d'un client : ";
	result = {};
	Fichier.read((char*)&result, sizeof(Client_s));
	if (Fichier.eof() && ClientEquals(result, {}))
		AjoutPoint(1);
	else
		AjoutPoint(0);
	resultCorrection << "/1\n";

	Fichier.close();
}

static void TestRechercheClient() {
	resultCorrection << "\n\nTest de la fonction RechercheClient :\n";
	int pointage = 0;
	lire << "Roberge\nJean-Francois\n"
		<< "5147883325\n" << 600
		<< " Fullum 10e Etage\nMontreal\nH2K3L6\n" << "Plante\nValerie\n"
		<< "5148720311\n" << 275
		<< " Notre Dame E\nMontreal\nH2Y1C6\n" << "Trudeau\nJustin\n"
		<< "6139575555\n" << 24
		<< " Sussez\nOttawa\nK1M1M4";
	NouveauClient();
	NouveauClient();
	NouveauClient();

	Client_s resultat = RechercherDossierClient(0);
	Client_s test = { "Gutenberg", "Johannes", "22101454", { 1455, "De la Bible", "Allemagne", "C1C1C1" }, Aujourdhui(), 0, { { -1, {}, {} }, { -1, {}, {} }, { -1, {}, {} } } };
	pointage += ClientEquals(resultat, test);
	resultCorrection << "\tRecherche du client {Gutenberg, Johannes} : " << ClientEquals(resultat, test) << "/1\n";

	resultat = RechercherDossierClient(1);
	test = { "Roberge", "Jean-Francois", "5147883325", { 600, "Fullum 10e Etage", "Montreal", "H2K3L6" }, Aujourdhui(), 0, { { -1, {}, {} }, { -1, {}, {} }, { -1, {}, {} } } };
	pointage += ClientEquals(resultat, test);
	resultCorrection << "\tRecherche du client {Roberge, Jean-Francois} : " << ClientEquals(resultat, test) << "/1\n";

	resultat = RechercherDossierClient(2);
	test = { "Plante", "Valerie", "5148720311", { 275, "Notre Dame E", "Montreal", "H2Y1C6" }, Aujourdhui(), 0, { { -1, {}, {} }, { -1, {}, {} }, { -1, {}, {} } } };
	pointage += ClientEquals(resultat, test);
	resultCorrection << "\tRecherche du client {Plante, Valerie} : " << ClientEquals(resultat, test) << "/1\n";

	resultat = RechercherDossierClient(45);
	test = { };
	pointage += ClientEquals(resultat, test);
	resultCorrection << "\tRecherche du client inexistant {} : " << ClientEquals(resultat, test) << "/1\n";

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/4\n";
}

static void TestRechercheLivre() {
	resultCorrection << "\n\nTest de la fonction RechercheLivre :\n";
	int pointage = 0;
	lire << "Office 2019\nCollette Michel";
	NouveauLivre();
	SetFlux();
	lire << "Petit guide de survie\nComité Chômage de Montréal";
	NouveauLivre();
	SetFlux();
	lire << "Programmer en langage C\nClaude Delannoy";
	NouveauLivre();
	SetFlux();
	lire << "Le langage C++\nClaus Richter";
	NouveauLivre();

	Livre_s resultat = RechercherLivre(0);
	Livre_s test = { "Un guide galactique", "Douglas Adam", false };
	pointage += (int)LivreEquals(resultat, test);
	resultCorrection << "\tRecherche du livre {Un guide galactique, Douglas Adam} : " << LivreEquals(resultat, test) << "/1\n";

	resultat = RechercherLivre(2);
	test = { "Petit guide de survie", "Comité Chômage de Montréal", false };
	pointage += (int)LivreEquals(resultat, test);
	resultCorrection << "\tRecherche du livre {Petit guide de survie, Comité Chômage de Montréal} : " << LivreEquals(resultat, test) << "/1\n";

	resultat = RechercherLivre(4);
	test = { "Le langage C++", "Claus Richter", false };
	pointage += (int)LivreEquals(resultat, test);
	resultCorrection << "\tRecherche du livre {Le langage C++, Claus Richter} : " << LivreEquals(resultat, test) << "/1\n";

	resultat = RechercherLivre(900);
	test = { };
	pointage += (int)LivreEquals(resultat, test);
	resultCorrection << "\tRecherche du livre inexistant {} : " << LivreEquals(resultat, test) << "/1\n";

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/4\n";
}

static void TestMiseJourLivre() {
	Livre_s maj = { "Petit guide de survie des chômeurs et chômeuses", "Comité Chômage de Montréal", true };
	MiseAJourLivre(2, maj);
	Livre_s recherche = RechercherLivre(2);

	resultCorrection << "\n\nTest de la fonction MiseAJourLivre :\n"
		<< "\tMise à jour du livre {Petit guide de survie des chômeurs et chômeuses, Comité Chômage de Montréal} : ";
	AjoutPoint(LivreEquals(recherche, maj));
	resultCorrection << "/1\n";
}

static void TestMiseJourClient() {
	Client_s maj = { "Plante", "Valerie", "5148820311", { 275, "Notre Dame E", "Montreal", "H2Y1C6" }, Aujourdhui(), 0, { { -1, {}, {} }, { -1, {}, {} }, { -1, {}, {} } } };
	MiseAJourClient(2, maj);
	Client_s recherche = RechercherDossierClient(2);

	resultCorrection << "\n\nTest de la fonction MiseAJourClient :\n"
		<< "\tMise à jour du client {Plante, Valerie} : ";
	AjoutPoint(ClientEquals(recherche, maj));
	resultCorrection << "/1\n";
}

static bool VerifLivreDansClient(const Client_s& client, const int id_livre) {
	for (size_t i = 0; i < 3; i++)
	{
		if (client.Prets[i].NumLivre == id_livre)
			return true;
	}

	return false;
}

static void TestLocation() {
	resultCorrection << "\n\nTest de la fonction Location :\n";
	size_t pointage = 0; bool resultat_test = false;
	Date_s location = Aujourdhui(), retour = AjouterJours(location, 15);

	DeleteFiles();
	// Création des livres de test
	Livre_s livre_1 = { "Petit guide de survie des chômeurs et chômeuses", "Comité Chômage de Montréal", false };
	Livre_s livre_2 = { "Un guide galactique", "Douglas Adam", false };
	Livre_s livre_3 = { "Office 2019", "Collette Michel", false };
	Livre_s livre_4 = { "Comment ne pas bien faire des tests ? Une application pratique", "Godefroy", false };

	// Création de trois clients
	Client_s client_1 = { "Plante", "Valerie", "5148820311", { 275, "Notre Dame E", "Montreal", "H2Y1C6" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };
	Client_s client_2 = { "Gutenberg", "Johannes", "22101454", { 1455, "De la Bible", "Allemagne", "C1C1C1" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };
	Client_s client_3 = { "Roberge", "Jean-Francois", "5147883325", { 600, "Fullum 10e Etage", "Montreal", "H2K3L6" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };

	// Ajout des livres à la BD
	std::fstream FichierLivre(FILENAME_LIVRE, std::ios::out | std::ios::binary);
	FichierLivre.write((char*)&livre_1, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_2, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_3, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_4, sizeof(Livre_s));
	FichierLivre.close();
	//Ajout des clients à BD
	std::fstream FichierClient(FILENAME_CLIENT, std::ios::out | std::ios::binary);
	FichierClient.write((char*)&client_1, sizeof(Client_s));
	FichierClient.write((char*)&client_2, sizeof(Client_s));
	FichierClient.write((char*)&client_3, sizeof(Client_s));
	FichierClient.close();

	// Test 1 : Location du livre_1 à client_1
	resultat_test = DateEqual(Location(0, 0), retour);
	pointage += resultat_test;
	resultCorrection << "\tLa date de location du livre " << livre_1.Titre << " est bien le " 
		<< retour.jour << "/" << retour.mois << "/" << retour.annee << " : " << resultat_test << "/1\n";

	// Test 2 : Le livre_1 est bien loué
	resultat_test = RechercherLivre(0).Loue;
	pointage += resultat_test;
	resultCorrection << "\tLe livre " << livre_1.Titre << " est marqué comme loué : " << resultat_test << "/1\n";

	// Test 3 : Le livre_1 est bien loué à client_1
	resultat_test = VerifLivreDansClient(RechercherDossierClient(0), 0);
	pointage += resultat_test;
	resultCorrection << "\tLocation effectuée du livre " << livre_1.Titre << " à la personne cliente "
		<< client_1.Prenom << " " << client_1.Nom << " : " << resultat_test << "/1\n";

	// Test 4 : Tentative de louer le livre_1 qui est déjà loué
	resultat_test = DateEqual(Location(0, 0), {});
	pointage += resultat_test;
	resultCorrection << "\tLe livre " << livre_1.Titre << " n'a pas pu être loué car il est déjà loué : " << resultat_test << "/1\n";

	// Location des livre_2 et livre_3 à client_1
	Location(0, 1);
	Location(0, 2);

	// Test 5 : Tentative de louer le livre_4 à client_1
	resultat_test = DateEqual(Location(0, 3), {});
	pointage += resultat_test;
	resultCorrection << "\tLe livre " << livre_3.Titre << " n'a pas pu être loué à la personne cliente "
		<< client_1.Prenom << " " << client_1.Nom << " car elle a atteinte son maximum : " << resultat_test << "/1\n";

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/5\n";
}

static void TestRetour() {
	resultCorrection << "\n\nTest de la fonction Retour :\n";
	size_t pointage = 0; bool resultat_test = false;
	Date_s location = Aujourdhui(), retour = AjouterJours(location, 15);

	DeleteFiles();
	// Création des livres de test
	Livre_s livre_1 = { "Petit guide de survie des chômeurs et chômeuses", "Comité Chômage de Montréal", false };
	Livre_s livre_2 = { "Un guide galactique", "Douglas Adam", false };
	Livre_s livre_3 = { "Office 2019", "Collette Michel", true };
	Livre_s livre_4 = { "Comment ne pas bien faire des tests ? Une application pratique", "Godefroy", false };

	// Création de trois clients
	Client_s client_1 = { "Plante", "Valerie", "5148820311", { 275, "Notre Dame E", "Montreal", "H2Y1C6" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };
	Client_s client_2 = { "Gutenberg", "Johannes", "22101454", { 1455, "De la Bible", "Allemagne", "C1C1C1" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };
	Client_s client_3 = { "Roberge", "Jean-Francois", "5147883325", { 600, "Fullum 10e Etage", "Montreal", "H2K3L6" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };

	// Location du Livre1 à Client1 avec aucun retard
	// Livre Chômage
	livre_1.Loue = true;
	client_1.Prets[0] = { 0, location, retour };
	// Location du Livre2 à Client1 avec deux jours de retard
	// Livre guide galactique
	livre_2.Loue = true;
	client_1.Prets[1] = { 1, location, retour };
	// Location du Livre3 à Client1 avec cinq jours de retard
	// Office
	livre_3.Loue = true;
	client_1.Prets[2] = { 2, location, retour };
	client_1.NombrePretActif = 3;
	// Location du Livre3 à Client2 avec cinq jours de retard
	// Bien faire ces tests
	// Ce livre ne sera pas retourné.
	livre_4.Loue = true;
	client_2.NombrePretActif++;
	client_2.Prets[0] = { 3, location, AjouterJours(location, -10) };

	// Ajout des livres à la BD
	std::fstream FichierLivre(FILENAME_LIVRE, std::ios::out | std::ios::binary);
	FichierLivre.write((char*)&livre_1, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_2, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_3, sizeof(Livre_s));
	FichierLivre.write((char*)&livre_4, sizeof(Livre_s));
	FichierLivre.close();
	//Ajout des clients à BD
	std::fstream FichierClient(FILENAME_CLIENT, std::ios::out | std::ios::binary);
	FichierClient.write((char*)&client_1, sizeof(Client_s));
	FichierClient.write((char*)&client_2, sizeof(Client_s));
	FichierClient.write((char*)&client_3, sizeof(Client_s));
	FichierClient.close();

	// Test 1 : Résultat de retour avec 0 jour de retard
	livre_1.Loue = false; // On indique que le livre est retourné
	resultat_test = (roundUp(Retour(0, 0, retour)) == 0.);
	pointage += resultat_test;
	resultCorrection << "\tRetour effectué pour " << livre_1.Titre << " avec aucun frais de retard : " << resultat_test << "/1\n";

	// Test 2 : Livre_1 est maintenant disponible
	resultat_test = LivreEquals(RechercherLivre(0), livre_1);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_1.Titre << " a bien été indiqué comme retourné : " << resultat_test << "/1\n";

	// Test 2 : Livre_2 est toujours loué
	resultat_test = LivreEquals(RechercherLivre(1), livre_2);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_2.Titre << " a bien été indiqué comme retourné : " << resultat_test << "/1\n";

	// Test 4 : Livre_3 est toujours loué
	resultat_test = LivreEquals(RechercherLivre(2), livre_3);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_3.Titre << " a bien été indiqué comme emprunté : " << resultat_test << "/1\n";

	// Test 5 : Le livre 1 n'est pas dans la liste des livres du client_1
	resultat_test = !VerifLivreDansClient(RechercherDossierClient(0), 0);
	pointage += resultat_test;
	resultCorrection << "\t" << client_1.Prenom << " " << client_1.Nom << " n'a pas le livre " << livre_1.Titre << " dans sa liste de livre emprunté : " << resultat_test << "/1\n";

	// Test 6 : Résultat de retour avec 2 jour de retard
	livre_2.Loue = false; // On indique que le livre est retourné
	Date_s retard_2jrs = AjouterJours(location, 17);
	resultat_test = (roundUp(Retour(0, 0, retard_2jrs)) == 11.5);
	pointage += resultat_test;
	resultCorrection << "\tRetour effectué pour " << livre_2.Titre << " avec 11.50 $ de frais de retard : " << resultat_test << "/1\n";
	
	// Test 7 : Livre_2 est maintenant disponible
	resultat_test = LivreEquals(RechercherLivre(1), livre_2);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_2.Titre << " a bien été indiqué comme retourné : " << resultat_test << "/1\n";

	// Test 8 : Livre_3 est toujours loué
	resultat_test = LivreEquals(RechercherLivre(2), livre_3);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_3.Titre << " a bien été indiqué comme emprunté : " << resultat_test << "/1\n";

	// Test 9 : Le livre 1 n'est pas dans la liste des livres du client_1
	resultat_test = !VerifLivreDansClient(RechercherDossierClient(0), 1);
	pointage += resultat_test;
	resultCorrection << "\t" << client_1.Prenom << " " << client_1.Nom << " n'a pas le livre " << livre_2.Titre << " dans sa liste de livre emprunté : " << resultat_test << "/1\n";

	// Test 10 : Résultat de retour avec 2 jour de retard
	livre_3.Loue = false; // On indique que le livre est retourné
	Date_s retour_20jrs_retard = AjouterJours(location, 20);
	resultat_test = (roundUp(Retour(0, 0, retour_20jrs_retard)) == 28.75);
	pointage += resultat_test;
	resultCorrection << "\tRetour effectué pour " << livre_3.Titre << " avec 28.47 $ de frais de retard : " << resultat_test << "/1\n";

	// Test 11 : Livre_4 est toujours loué
	resultat_test = LivreEquals(RechercherLivre(3), livre_4);
	pointage += resultat_test;
	resultCorrection << "\tLe " << livre_4.Titre << " a bien été indiqué comme emprunté : " << resultat_test << "/1\n";

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/11\n";
}

void TestAfficherLivre() {
	resultCorrection << "\n\nTest de la fonction AfficherLivre :\n";
	//Livre_s livre_1 = { "Petit guide de survie des chômeurs et chômeuses", "Comité Chômage de Montréal", false };

	std::cout << "-------------Afficher livre-------------\n\n\nDONNÉE ATTENDU (dispo) :\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "ID du livre : " << 0 << "\n"
		<< "Titre du livre : Petit guide de survie des chômeurs et chômeuses\n"
		<< "Auteur du livre : Comité Chômage de Montréal\n"
		<< "Disponible : Oui"
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	AfficherLivre(0);
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Combien de donnée presente est valide (max 4) ? ";
	size_t affichage, pointage = 0;
	affichage = _getche() - 48;
	if (affichage < 0 || affichage > 9)
		affichage = 0;
	clrscr();
	pointage = (affichage > 4 ? 4 : affichage);
	resultCorrection << "\tAffichage des données du livre {Petit guide de survie des chômeurs et chômeuses, Comité Chômage de Montréal} : "
		<< (affichage > 4 ? 4 : affichage) << "/4\n";

	std::cout << "-------------Afficher livre-------------\n\n\nDONNÉE ATTENDU (non-dispo) :\n===========================\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "Ce livre n'existe pas."
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	SetFlux();
	AfficherLivre(900);
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Est-ce que le message est bien present (O/N) ? ";
	char rep = toupper(_getche());
	if (rep == 'O')
		pointage++;
	resultCorrection << "\tAffichage des données du livre inexistant { } : "
		<< (rep == 'O') << "/1\n";
	clrscr();

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/5\n";
}

void TestAfficherDossierClient() {
	resultCorrection << "\n\nTest de la fonction AfficherDossierClient :\n";
	// Client_s client_2 = { "Gutenberg", "Johannes", "22101454", { 1455, "De la Bible", "Allemagne", "C1C1C1" }, Aujourdhui(), 0, { {-1, {}, {} }, {-1, {}, {} }, {-1, {}, {} } } };

	std::cout << "-------------Afficher client-------------\n\n\nDONNÉE ATTENDU (dispo) :\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "ID du client : 1\n"
		<< "Nom du client : Gutenberg\n"
		<< "Prénom du client : Johannes\n"
		<< "Téléphone du client : 22101454\n"
		<< "Adresse du client : " << 1455 << " De la Bible, Allemagne (C1C1C1)\n"
		<< "Nombre de livre prêté : 1\n"
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	AfficherDossierClient(1);
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Combien de donnée presente est valide (max 9) ? ";
	size_t affichage, pointage = 0;
	affichage = _getche() - 48;
	if (affichage < 0 || affichage > 9)
		affichage = 0;
	clrscr();
	pointage = (affichage > 9 ? 9 : affichage);
	resultCorrection << "\tAffichage des données du client {Gutenberg, Johannes} : "
		<< (affichage > 9 ? 9 : affichage) << "/9\n";

	std::cout << "-------------Afficher client-------------\n\n\nDONNÉE ATTENDU (non-dispo) :\n===========================\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "Ce client n'existe pas."
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	SetFlux();
	AfficherDossierClient(900);
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Est-ce que le message est bien present (O/N) ? ";
	char rep = toupper(_getche());
	if (rep == 'O')
		pointage++;
	resultCorrection << "\tAffichage des données du client inexistant { } : "
		<< (rep == 'O') << "/1\n";
	clrscr();

	resultCorrection << "\t\tTotal : ";
	AjoutPoint(pointage);
	resultCorrection << "/10\n";
}

void TestListeDesLivresPretes() {
	resultCorrection << "\n\nTest de la fonction ListeDesLivresPretes :\n";
	//Livre_s livre_4 = { "Comment ne pas bien faire des tests ? Une application pratique", "Godefroy", false };

	std::cout << "-------------Afficher liste livre prêté-------------\n\n\nDONNÉE ATTENDU (dispo) :\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "Liste des livres Prêtés\n=======================\nID : Titre\n----------\n3 : Comment ne pas bien faire des tests ? Une application pratique"
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	ListeDesLivresPretes();
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Combien de donnée presente est valide (max 2) ? ";
	size_t affichage, pointage = 0;
	affichage = _getche() - 48;
	if (affichage < 0 || affichage > 9)
		affichage = 0;
	clrscr();
	pointage = (affichage > 2 ? 2 : affichage);

	resultCorrection << "\tAffichage du livre prêté {Programmer en langage C, Claus Richter} : ";
	AjoutPoint(pointage);
	resultCorrection << "/2\n";
}

void TestListeDesClientsEnRetard() {
	Date_s date_retour = AjouterJours(Aujourdhui(), -10);
	resultCorrection << "\n\nTest de la fonction ListeDesClientsEnRetard :\n";
	std::cout << "-------------Afficher liste client en retard-------------\n\n\nDONNÉE ATTENDU (dispo) :\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< "Liste des clients en retard\n=======================\n\nNom (Téléphone) : Date de retour prévu\n----------\n"
		<< "Johannes Gutenberg (22101454) : " << date_retour.jour << "/" << date_retour.mois << "/" << date_retour.annee
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	ListeDesClientsEnRetard();
	std::cout << "\n\nAFFICHAGE DE LA PERSONNE ETUDIANTE\n"
		<< ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n"
		<< ecrire.str()
		<< "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n";
	std::cout << "Combien de donnée presente est valide (max 3) ? ";
	size_t affichage, pointage = 0;
	affichage = _getche() - 48;
	if (affichage < 0 || affichage > 9)
		affichage = 0;
	clrscr();
	pointage = (affichage > 3 ? 3 : affichage);

	resultCorrection << "\tAffichage du client en retard {Gutenberg, Johannes} : ";
	AjoutPoint(pointage);
	resultCorrection << "/3\n";
}

void RunTest() {
	resultCorrection.str("");
	setwsize(149, 30);
	DeleteFiles();
	CreateCorrectionFile();

	TestNouveauLivre();
	SetFlux(); TestNouveauClient();
	SetFlux(); TestRechercheLivre();
	SetFlux(); TestRechercheClient();
	SetFlux(); TestMiseJourLivre();
	SetFlux(); TestMiseJourClient();
	SetFlux(); TestLocation();
	SetFlux(); TestRetour();
	SetFlux(); TestAfficherLivre();
	SetFlux(); TestAfficherDossierClient();
	SetFlux(); TestListeDesLivresPretes();
	SetFlux(); TestListeDesClientsEnRetard();

	CloseCorrection();

	if (globalFileName == "--null") {
		std::string str = resultCorrection.str();
		std::cout << str << "\nAppuyez sur une touche pour continuer.";
		_getch();
	}
}
#endif // DEBUG