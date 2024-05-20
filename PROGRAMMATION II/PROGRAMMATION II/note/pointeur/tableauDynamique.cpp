#include <iostream>
// Pour malloc et free
//#include <cstdlib>

using std::cout; using std::cin;

int main() {
	int taille;
	cout << "Combien ? ";
	cin >> taille;

	/**************************************
	* EN C PUR
	***************************************/

	// Alloue taille octet
	//void* variable = malloc(taille);

	// Alloue un pointeur entier
	//int* variable = (int*)malloc(sizeof(int));

	// Alloue un tableau
	//int* variable = (int*)malloc(taille * sizeof(int));

	//for (size_t i = 0; i < taille; i++)
	//{
	//	*(variable + i) = i;
	//}

	/*for (size_t i = 0; i < taille; i++)
	{
		cout << variable[i] << "\n";
	}*/

	//// Lib rer la m moire
	//free(variable);

	/**************************************
	* EN C++
	***************************************/
	/*int* variable = new int;
	cout << *variable;

	delete variable;*/

	// Tableau
	int* tableau = new int[taille];

	for (size_t i = 0; i < taille; i++)
	{
		*(tableau + i) = i;
	}

	for (size_t i = 0; i < taille; i++)
	{
		cout << tableau[i] << "\n";
	}

	delete[] tableau;
}