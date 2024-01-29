#include "..\cvm 21.h"
#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>
#include  <math.h>

using namespace std;

int main() {
	// variables
	int fin = 10;
	int i = 0;
	int x = 0;
	int y = 0;
	double rayon;
	double air;
	double pi = 2 * acos(0.0);
	string Qui = "Je suis Benjamin Jonvil, je suis ag\x82 de 24 ans";// accent
	string Parcours = "Mon parcours acad\x82mique \x85 recull\x82 durant la derni\x8are ann\x82/e. En effet, j'ai d\x82j\x85  reàx80u mon DEC et je suis allez \x85  l'universit\x82 en g\x82nie logiciel et informaique, pour ensuite revenir au CEGEP. Je suis \x82galement officier dans les FAC en tant qu'O cadet. Je suis officier d'administratione et de marche militaire. Par contre, Je pense changer de m\x82tier dans les foces pour officiers de transmission.";
	string Interet = "Je trouve int\x82ressant l'informatique. J'aimerais travailler dans les AI";// accent
	char choix;
	bool fini = false;

	//constante
	const string Q1 = "Qui \x88tes-vous ?";// accent
	const string Q2 = "Quel est votre parcours acad\x82mique et/ou professionnel ?"; // accent
	const string Q3 = "Qu'est-ce qui vous int\x82resse dans la programmation et la technique ?";// accent
	const string Q4 = "Demandez \x85 la personne utilisatrice un rayon et calculer l'aire d'un cercle.";// accent
	const string MESS_DEBUT = " Message de pr\x82sentation";// accent
	const string REC = "Voulez-vous recommencer?(Y/N)";
	const string MESS_AUR = "AU REVOIR :)";
	const string PS = "PS: Je voulais devenir physicien, lorsque j'\x82tais au secondaire";
	 
	
	// placement du titre
	x = 25;
	y = 0;

	//boucle
	do {

		//Affichage
		gotoxy(x, y);
		cout << MESS_DEBUT << endl;
		cout << endl;
		x = 0;
		gotoxy(x,y);
		cout << endl;
		cout << Q1 << endl;
		cout <<"\t"<<  Qui << endl;
		cout << endl;
		cout << Q2 << endl;
		cout << "\t" << Parcours << endl;
		cout << endl;
		cout << Q3 << endl;
		cout << "\t" << Interet << endl;
		cout << endl;
		cout << Q4 << endl;
		cin >> rayon;

		//calcule
		air = pi * (rayon * rayon);

		//affichage
		cout << endl << air << "cm\375" << endl;
		cout << REC << endl; 
		choix = _getch();
		choix = toupper(choix );
		cout << choix ;

		//continuer
		if (choix == 'Y') {
			fini = false;
			clrscr();
		}
		else if (choix == 'N') {
			fini = true;
			clrscr();
			cout << MESS_AUR;
			cout << endl;
			cout << PS ;
			cout << endl;
		}
	} while (fini == false);	
}





