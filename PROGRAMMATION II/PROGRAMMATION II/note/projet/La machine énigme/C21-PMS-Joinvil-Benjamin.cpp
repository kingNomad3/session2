#include <iostream>
#include <string>
#include "windows.h"
#include <conio.h>
#include "../cvm23.h"



// Cette fonction � �t� reprise lors du cours de programation 2 hiver 2023 Godefroy Borduas
void io_clean()										// pour vider les 2 tampons
{
	std::cin.clear();									// s'assure que le cin est remis en marche
	std::cin.ignore(std::cin.rdbuf()->in_avail());			// vide le tampon du cin
	while (_kbhit()) (void)_getch();				// vide le tampon de la console
}

struct VariablePhrase_s {

	std::string Message;
	std::string resultat = "";
	std::string Original = "";
	char typo = ' ';
	char ChoixAffDe = ' ';
	
};

struct Calcule_s {

	int C = 0;
	int cle = 0;
	const int x = 40;
	const int y = 5;
	int SelectionCle[3] = {0, 0,0};
	bool Verifier;

};


//structure avec tout les messages qui seront utilis�
struct MESSAGE_s {

	const std::string MESS_MENU = "Bienvenue dans la machine Benigma.";
	const std::string MESS_MENU1 = "Elle permait de decrypter un message � son point de d�part et de d�crypter le message � son point d'arriv�e. ";
	const std::string MESS_COMMENCER = "Voulez-vous commencer? (appuyez sur une touche)";
	const std::string TELECHARGEMENT = "T�l�chargement";
	const std::string PHRASE = " Entrez votre phrase et appuyer sur la touche enter";
	const std::string VOIR_MESSAGE_DECO = " Voulez-vous d�chiffrer le message? O/N";
	const std::string MESS_AFFICHE = "Le message est:";
	const std::string ENTREZ_CLE = "Entrez la cl� et appuyer sur la toucher enter ";
	const std::string ENTER = "Appuyer sur la toucher enter";
	const std::string FIN = " Au revoir!";
};

//�tape 1: Sasir la phrase de l'utilisateur qui sera cod�
std::string SaisirPhrase(VariablePhrase_s& PhraseAEncoder) {
	io_clean();
	MESSAGE_s MESS;
	Calcule_s x, y;

	setcolor(Color::yel);
	gotoxy(x.x - 5, y.y);
	std::cout << MESS.PHRASE << std::endl;
	gotoxy(x.x + 15, y.y + 1);
	std::cin >> PhraseAEncoder.Original;

	return PhraseAEncoder.Original;
}


//�tape 2: Sasir les cl�s de l'utilsateur
void SaisirCle(Calcule_s& Cle) {
	setcp(1252);

	Calcule_s x, y,digit;
	MESSAGE_s MESS;

	for (int i = 0; i < 4; i++) {
		clrscr();
		digit.Verifier = false;
		
		while (digit.Verifier == false) {
			gotoxy(x.x, y.y);
			setcolor(Color::yel);
			std::cout << MESS.ENTREZ_CLE;
			setcolor(Color::aqua);
			std::cout << i + 1 << " :";
			clreoscr();
			std::cin >> Cle.SelectionCle[i];

			if (isdigit(Cle.SelectionCle[i]) || std::cin.fail()) {
				digit.Verifier = false;
				io_clean();
				std::cin.clear();	
			}
			else {
				digit.Verifier = true;
				break;
			}	
		} 
	}
}

void verificationdigit() {

}

//�tape 3: Calcule les cl�s et code la phrase 
int Cleutilise(Calcule_s& Cle) {
	
	if (Cle.cle == 0) {
		for (int i = 0; i < 4; i++) {
			Cle.cle += Cle.SelectionCle[i];
		}
	}
	else if (Cle.cle > 0) {
		Cle.SelectionCle[0] += 1;
		Cle.SelectionCle[1] += 2;
		Cle.SelectionCle[2] += 3;
		Cle.SelectionCle[3] += 21;
		for (int i = 0; i < 4; i++) {
			Cle.cle += Cle.SelectionCle[i];
		}
	}
	return Cle.cle;
}

//�tape 4.1:Calcule le changement de lettre ||{ 7,15,24,6 }- � partir de la troisi�me lettre le resultat fait +1 ensuite +2, etc. ie: star = sudx != sucu  
std::string ChangementDeLettre(Calcule_s& Cle, Calcule_s& C) {

	VariablePhrase_s R;
	VariablePhrase_s T;
	if (C.C >= 'A' && C.C <= 'Z') {
		T.typo = 'A';
		C.C -= T.typo; // On place la lettre A � 0
		C.C = ((C.C + Cleutilise(Cle)) % 26 + 26) % 26;
		C.C += T.typo; // on replace la lettre A dans la table ASCII
		R.resultat += C.C;
	}
	else if (C.C >= 'a' && C.C <= 'z') {
		 T.typo = 'a';
		C.C -= T.typo;
		C.C = ((C.C + Cleutilise(Cle)) % 26 + 26) % 26;
		C.C += T.typo;
		R.resultat += C.C;
	}
	else
		R.resultat += (char)C.C;
	return R.resultat;
}

//�tape 4.2:Calcule le changement de lettre
std::string CryptageBen(VariablePhrase_s& Original, Calcule_s& Cle, Calcule_s& C) {
	
	VariablePhrase_s R;
	 R.resultat = "";
	for (int i = 0; i < Original.Original.length(); i++) {
		C.C = (int)Original.Original.at(i);
		R.resultat += ChangementDeLettre(Cle, C);//le C?
	}
	return R.resultat;
}

//�tape 5: D�chiffre la phrase|| Ne fonctionne pas 
std::string dechiffrementBen(VariablePhrase_s& Original, Calcule_s& Cle, Calcule_s& C, VariablePhrase_s& PhraseAEncoder) {

	

	for (int i = 0; i <= 3; i++) {
		if (Cle.cle == 0) {
			Cle.cle -= Cle.SelectionCle[i];
			Cle.cle -= Cle.SelectionCle[i];
			Cle.cle -= Cle.SelectionCle[i];
			Cle.cle -= Cle.SelectionCle[i];	
		}
		else if (Cle.cle > 0) {
			Cle.SelectionCle[i] -= 1;
			Cle.SelectionCle[i] -= 2;
			Cle.SelectionCle[i] -= 3;
			Cle.SelectionCle[i] -= 21;
			Cle.cle -= Cle.SelectionCle[i];
		}
	}
	return PhraseAEncoder.Original;
}

//�tape 6: Saisie Si l'utilisateur veux voir la phrase d�coder 
char MessageCoderFin(VariablePhrase_s& ChoixAffDe, VariablePhrase_s& PhraseAEncoder,  Calcule_s& Cle, Calcule_s& C) {
	Calcule_s x, y;
	MESSAGE_s MESS;

	gotoxy(x.x, y.y);
	std::cout << MESS.VOIR_MESSAGE_DECO;
	
	for (int i = 0; ChoixAffDe.ChoixAffDe != 'N' && ChoixAffDe.ChoixAffDe != 'O'; i++) {
		gotoxy(x.x+15, y.y + 1);
		ChoixAffDe.ChoixAffDe = toupper(_getch());
		std::cout << ChoixAffDe.ChoixAffDe;
		clreol();
		if (ChoixAffDe.ChoixAffDe == 'N' || ChoixAffDe.ChoixAffDe == 'n') {
			gotoxy(x.x + 10, y.y + 2);
			setcolor(Color::grn);
			std::cout << std::endl << MESS.FIN;
		}
		else if (ChoixAffDe.ChoixAffDe == 'O' || ChoixAffDe.ChoixAffDe == 'o') {
			gotoxy(x.x+10, y.y + 2);
			setcolor(Color::red);
			std::cout << MESS.MESS_AFFICHE ;
			gotoxy(x.x+15, y.y + 3);
			PhraseAEncoder.Original = dechiffrementBen(PhraseAEncoder, Cle, C, PhraseAEncoder);
			std::cout << PhraseAEncoder.Original << "\t";
			continue;
		}
	}
	return ChoixAffDe.ChoixAffDe;
}


// �tape de t�l�chargement, aucune vrai utilit�
void Telechagement (Calcule_s& x, Calcule_s& y){
	setcp(1252);
	MESSAGE_s MESS;
	setcolor(Color::pur);
	gotoxy(x.x + 10, y.y + 3);
	std::cout << MESS.TELECHARGEMENT; Sleep(1000); std::cout << "."; Sleep(1000); std::cout << "."; Sleep(1000); std::cout << ".";
	clrscr();
}

std::string CryptageBen(VariablePhrase_s& Original, Calcule_s& Cle, Calcule_s& C);
std::string dechiffrementBen(VariablePhrase_s& Original, Calcule_s& Cle, Calcule_s& C);

int main() {

	setcp(1252);

	VariablePhrase_s Choix, Original, ChoixAffDe, PhraseAEncoder;
	Calcule_s Cle, C,x,y;
	MESSAGE_s MESS;

	//Messages du menu principale
	setcolor(Color::grn);
	gotoxy(x.x, y.y);
	std::cout << MESS.MESS_MENU;
	gotoxy(x.x - 30, y.y + 1);
	std::cout << MESS.MESS_MENU1 << std::endl;
	gotoxy(x.x - 5, y.y + 2);
	setcolor(Color::yel);
	std::cout << MESS.MESS_COMMENCER << std::endl;
	_getch();
	clrscr();

	//Page de t�l�chargement
	Telechagement(x, y);

	//appel de la fonction qui saisie la phrase de l'�tape 1
	gotoxy(x.x, y.y + 2);
	clrscr();
	SaisirPhrase(PhraseAEncoder);

	//appel de la fonction qui saisie les cl� � l'�tape2
	clrscr();
	setcolor(Color::aqua);
	SaisirCle(Cle);
	PhraseAEncoder.Message = CryptageBen(PhraseAEncoder, Cle, C);
	clrscr();

	//Page de t�l�chargement
	Telechagement(x, y);

	//affiche la fonction qui permet de faire le changement de lette �tape 3 � 4
	setcolor(Color::grn);
	gotoxy(x.x + 10, y.y);
	std::cout << MESS.MESS_AFFICHE;
	gotoxy(x.x + 15, y.y + 1);
	std::cout << PhraseAEncoder.Message << "\t";
	gotoxy(x.x + 5, y.y + 2);
	setcolor(Color::yel);
	std::cout << MESS.ENTER;
	_getch();

	//appel les fonction qui permette de calculer et de d�chifrer les �tapes 5 et 6
	clrscr();
	MessageCoderFin(ChoixAffDe, PhraseAEncoder, Cle, C);
}

VariablePhrase_s PhraseAEncode;
VariablePhrase_s R;
Calcule_s Cle;
Calcule_s C;