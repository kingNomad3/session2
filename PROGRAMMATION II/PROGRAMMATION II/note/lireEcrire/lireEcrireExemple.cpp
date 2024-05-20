#include <iostream>
#include <string>
#include <fstream>
#include <ctime>
#include <windows.h>

using std::fstream; using std::ios;

int main() {
	fstream Fichier;
	//Fichier.open("helloworld.txt", ios::out);

	//Fichier << "Hello World !";

	Fichier.open("helloworld.txt", ios::in);
	if (Fichier.fail())
		exit(EXIT_FAILURE);

	while (!Fichier.eof())
	{
		std::cout << (char)Fichier.get();
		Sleep(1000);
	}


	//std::cout << "Hello";
	//std::string message;
	////Fichier >> message;
	////while (!Fichier.eof())
	//for(size_t i = 0; i < 2 && !Fichier.eof(); i++)
	//{
	//	std::getline(Fichier, message);
	//	std::cout << message << "\n";
	//}


	/*Fichier.open("helloworld", ios::app);

	Fichier << "Hello " << time(NULL) << "\n";*/

	Fichier.close();
}