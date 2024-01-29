#include <fstream>
//#include <string>
#include <iostream>

using std::fstream; using std::ios;
//using namespace std;

int main() {
	fstream Fichier;
	std::string nomfichier;
	std::cin >> nomfichier; 
	std::string fichierfinale = nomfichier + ".txt";


	if (fichierfinale == "Helloword.txt") {
		Fichier.open("Helloword.txt",ios::in|ios::out);


	}else {
		if (Fichier.fail()) {
			exit(EXIT_FAILURE);
		}
	}


	//std::cout << Fichier;

	while (!Fichier.eof()) {
		std::cout << (char)Fichier.get();
		int Caractere = (char)Fichier.get();
		
	}

	//Fichier << "Hello mtf";
	Fichier.close();

}