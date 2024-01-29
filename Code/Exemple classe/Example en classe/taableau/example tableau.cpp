#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

/*

INITIALISATION DES TABLEAUX LORD DE LA D�FINITION

	Syntaxe particuli�re

		1) type nom[n];							// toutes les valeurs sont ind�finies

		2) type nom[n] = {};					// toutes les valeurs sont initilis�es � z�ro, ou l'�quivalent en fonction du type (ex: string ==> "")

		3) type nom[n] = { V1, V2, ..., Vn };	// possibilit� de sp�cifier explicitement les premi�res valeurs, le reste est initialis�e � z�ro, ou l'�quivalent.

		note: si la valeur Vn est donn�e alors la valeur Vn-1 aussi.


	Attention: cette syntaxe  " = {...} "  est disponible seulement lors de la d�finition du tableau

		nom = {...};	// ==> erreur de compilation

*/

int main()
{
	// EXEMPLES:  (idem si les tableaux sont constants: "const")

	int T[5] = { 10, 20 };										// le reste � 0

	bool r�ponses[20] = { true, false, true };					// le reste � false

	double temperature[6] = { 0, 22.5, 0, -15.7 };				// le reste � 0

	string salutations[4] = { "bonjour", "salut" , "allo" };	// le reste � chaine vide ""

	// ...

	// salutations = { "bonjour", "salut" , "allo" };  ==> interdit

	_getch();
}