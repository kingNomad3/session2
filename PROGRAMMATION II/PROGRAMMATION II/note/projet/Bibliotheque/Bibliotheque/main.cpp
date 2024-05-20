#include "flux_io.h"
#include "cvm23.h"
#include "Livres.h"
#include "Clients.h"
#include "Location.h"
#include "type.h"
#include "utils.h"
#include <conio.h>



#ifdef __CORRECTION__
#include "test.h"

std::string globalFileName;

// Ne touchez pas  cette fonction.
// Si vous la modifiez, vous aurez automatiquement la note de 0
int main_correction(int argc, char** argv) {
	setcp(1252);

	if (argc > 1) {
		globalFileName = argv[1];
	}
	else
		globalFileName = "--null";

	RunTest();

	return 0;
}
#else
 //Ajoutez votre main dans cette fonction

static void main_etu() {
	setcp(1252);
	char ChoixEtudiant;
	
	do {
		clrscr();
		
		ecrire << "===========================================" << std::endl;
		ecrire << " ClinOeil - Logiciel de gestion de la bibliothèque" << std::endl;
		ecrire << "===========================================" << std::endl;
		ecrire << "1 - Ajouter un livre à la collection" << std::endl;
		ecrire << "2 - Créer une nouvelle personne usager" << std::endl;
		ecrire << "3 - Rechercher un dossier de personne usager" << std::endl;
		ecrire << "4 - Effectuer la location d'un livre" << std::endl;
		ecrire << "5 - Effectuer le retour d'un livre" << std::endl;
		ecrire << "6 - Afficher la liste des livres prêtés" << std::endl;
		ecrire << "7 - Afficher la liste des personnes usagers en retard" << std::endl;
		ecrire << "8 - Fermer l'application" << std::endl;
		
		 ChoixEtudiant = _getch();

		switch (ChoixEtudiant) {
		case '1':
			NouveauLivre();
			ecrire << "Appuyez sur une touche pour continuer.";
			_getch();
			clreoscr();
			break;
		case '2':
			NouveauClient();
			ecrire << "Appuyez sur une touche pour continuer.";
			_getch();
			break;
		case '3':
			
			RechercherClientMain(); 
			break;
		case '4':
			LocationMain();
			
			break;
		case '5':
			RetourMain();
			ecrire << "Appuyez sur une touche pour continuer.";
			_getch();
			break;
		case '6':
			ListeDesLivresPretes(); 
			break;
		case '7':
			ListeDesClientsEnRetard();
			break;
		case '8':
			ecrire << "Fermeture de l'application...\n";
			ChoixEtudiant = 8;
			continue;
		default:
			ecrire << "Choix invalide. Veuillez entrer un chiffre entre 1 et 8.\n";
			_getch();
			break;
		}
	} while (ChoixEtudiant != 8);

}
#endif

int main(int argc, char** argv) {
#ifdef __CORRECTION__
	main_correction(argc, argv);
#else
	main_etu();
#endif  __CORRECTION__
	return 0;
}