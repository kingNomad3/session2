#include <iostream>

using std::cout;

int main() {
	float base = 3;
	float* pointeur = &base;
	cout << &base << "\n" << pointeur;

	cout << "\n\n";

	cout << base << "\n" << *pointeur;

	cout << "\n\n";

	long double tab[2] = { 1, 0 };
	cout << &tab[0] << "\n" << &tab[1];

	cout << "\n\n" << &tab[0] << "\n" << tab[1];

	cout << "\n\n" << tab[0] << "\n" << *tab;

	cout << "\n\n" << pointeur << "\n" << pointeur + 1;
	cout << "\n\n" << tab << "\n" << *(tab + 2) << "\n" << &tab[1];

	for (size_t i = 0; i < 10; i++)
	{
		cout << "\n" << *(tab + i);
		//*(tab + i) = i * i;
		cout << "\t" << *(tab + i);
	}
}