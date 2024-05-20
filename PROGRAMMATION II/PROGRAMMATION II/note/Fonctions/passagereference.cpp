#include <iostream>
using namespace std;

/*	PASSAGE PAR VALEUR:
*
*	Ceci est le passage par d�faut des types simples
*	de C++. La valeur en param�tre � b � est alors copi�
*	dans une nouvelle case m�moire.
*/
void PassageValeur(int);

/*	PASSAGE PAR R�F�RENCE:
*
*	Dans le passage par r�f�rence, la valeur n'est pas copi�.
*	La fonction utilise un lien vers la valeur d'origine et elle
*	peut alors la modifier.
*
*	Il s'agit de la m�thode utiliser pour les tableaux. Elle peut
*	�tre utiliser pour les types simple gr�ce au symbole � & �.
*/
void PassageReference(int&);

void PassageConstRef(const int&);

int Retour2Valeurs(int a, int b, int& c) {
	c += 5;
	if (a > b)
		return a + c;
	else
		return b + c;
}

int main() {
	int a = 5;
	cout << "Main (avant PassageValeur) :" << a << "\n";
	PassageValeur(a);
	cout << "Main (apres PassageValeur) :" << a << "\n\n";

	cout << "Main (avant PassageReference) :" << a << "\n";
	PassageReference(a);
	cout << "Main (apres PassageReference) :" << a << "\n";

	PassageConstRef(a);

	int e = 1, f = 0, g = 0;
	int max = Retour2Valeurs(e, f, g);
	cout << g << " " << max;
}

void PassageValeur(int b) {
	b += 5;
	cout << "PassageValeur :" << b << "\n";
}

void PassageReference(int& b) {
	b += 5;
	cout << "PassageReference :" << b << "\n";
}

void PassageConstRef(const int& b) {
	cout << "PassageConstRef :" << b << "\n";
}