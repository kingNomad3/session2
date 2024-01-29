
#ifndef RECTANGLE_H
#define RECTANGLE_H

#include <string>
#include <fstream>

const char CARACTERE_FORME = '*'; // Installe une uniformité dans le programme et facilité les mises à jour
const char CARACTERE_ESPACE = ' ';
const char SAUT_DE_LIGNE = '\n';

std::string DessinerLigne(int, int);
std::string DessinerForme(int, int, int);
//std::string DessinerFichier(int, int, int, int);
std::string DessinerLigneVide(int);

bool GenererFichier(std::string);
bool GenererFichier(int, int, int, int); // Surcharge de fonction

#endif