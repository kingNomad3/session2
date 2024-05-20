#include fstream
#include iostream
#include string

using namespace std;

int main() {
	string Chemin;
	fstream Fichier;
	int nbLigne = 0;

	do {
		Fichier.ignore();
		Fichier.clear();

		cout  Entrez une chemin valide vers le fichier;
		getline(cin, Chemin);

		Fichier.open(Chemin, iosin);
	} while (Fichier.fail());

	while (!Fichier.eof()) {
		cout  ++nbLigne;

		char C;
		int nbCaractere = 0;
		while ((C = (char)Fichier.get()) != 'n' && !Fichier.eof()) {
			if (nbCaractere++  100)
				if (++nbCaractere = 100)
					cout  C;
		}

		cout  n;
	}

	Fichier.close();
}