#include <fstream>
#include <iostream>

using namespace std;

int main() {
	/*fstream Fichier;
	Fichier.open("fibo.bin", ios::out | ios::binary);*/

	////long double a = 42;

	////Fichier.write((char*)&a, sizeof(long double));

	/*long long terme1 = 1, terme2 = 1;
	Fichier.write((char*)&terme1, sizeof(long long));
	Fichier.write((char*)&terme2, sizeof(long long));

	int i = 2;
	while (i++ < 500) {
		int temp = terme1 + terme2;
		terme1 = terme2;
		terme2 = temp;

		Fichier.write((char*)&terme2, sizeof(long long));
	}*/

	//Fichier.close();

	fstream Fichier;
	Fichier.open("fibo.bin", ios::in | ios::out | ios::binary);

	Fichier.seekp(sizeof(long long) * 3, ios::beg);
	long long a = 42;
	Fichier.write((char*)&a, sizeof(long long));

	//int terme, i = 0;
	//while (/*i++ < 5000 && */!Fichier.eof())
	//{
	//	Fichier.read((char*)&terme, sizeof(int));
	//	cout << i++ << " : " << terme << "\n";
	//}

	/*int nbterme, terme;

	cout << "Taille fichier : ";
	Fichier.seekp(0, ios::end);
	cout << Fichier.tellp() << "\n";
	Fichier.seekp(0, ios::beg);

	cout << "Quel terme ? ";
	cin >> nbterme;

	Fichier.seekp(sizeof(int) * (nbterme - 1), ios::beg);

	Fichier.read((char*)&terme, sizeof(int));
	cout << nbterme << " : " << terme << "\n";*/

	Fichier.close();
}