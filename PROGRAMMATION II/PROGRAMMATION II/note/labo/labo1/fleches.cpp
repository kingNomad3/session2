#include <iostream>
#include <conio.h>

#include "cvm23.h"

enum class ArrowKeys
{
    UP_LEFT = 71, UP = 72, UP_RIGHT = 73,
    LEFT = 75, RIGHT = 77,
    DOWN_LEFT = 79, DOWN = 80, DOWN_RIGHT = 81
};

using std::cout;
using std::cin;

int main() {
    const size_t LARGEUR = 100, HAUTEUR = 50;
    const uint8_t ESCAPE = 27; // Valeur de la touche �chap�e pour sortir
    Position valeurs = {0, 0}, fleche = {0, 0};
    uint8_t c;

    setcp(1252);

    setwsize(LARGEUR, HAUTEUR);

    setcolor(Color::red);
    gotoxy(0, 25);
    cout << "Appuyez sur ESCAPE pour sortir.";

    setcolor(Color::gry);
    gotoxy(3, 5); cout << "Valeur du clavier s�lectionn� : "; valeurs = wherexy();
    gotoxy(3, 6); cout << "Fl�che appuy�e : "; fleche = wherexy();

    do {
        c = _getch(); // On r�cup�re la touche
        // On efface les messages
        gotoxy(valeurs.x, valeurs.y); clreol();
        gotoxy(fleche.x, fleche.y); clreol();

        // On affiche le premier caract�re
        gotoxy(valeurs.x, valeurs.y);
        cout << c << "(" << (int)c << ")";
        
        // Si c'est du numpad ou du arrowpad
        if (c == 0 || c == 224) {
            // Au cas o� il n'aurait pas de second caract�res
            if (_kbhit()) {
                c = _getch();
                cout << ", " << c << "(" << (int)c << ")";

                gotoxy(fleche.x, fleche.y);
                switch (ArrowKeys(c)) // On converti le caract�re dans l'�num�ration
                {
                case ArrowKeys::UP_LEFT:
                    cout << "Haut gauche";
                    break;
                case ArrowKeys::UP:
                    cout << "Haut";
                    break;
                case ArrowKeys::UP_RIGHT:
                    cout << "Haut droite";
                    break;
                case ArrowKeys::LEFT:
                    cout << "Gauche";
                    break;
                case ArrowKeys::RIGHT:
                    cout << "Droite";
                    break;
                case ArrowKeys::DOWN_LEFT:
                    cout << "Bas gauche";
                    break;
                case ArrowKeys::DOWN:
                    cout << "Bas";
                    break;
                case ArrowKeys::DOWN_RIGHT:
                    cout << "Bas droite";
                    break;
                default:
                    break;
                }
            }
            else
            {
                gotoxy(fleche.x, fleche.y);
                cout << "Aucune fl�che s�lectionn�e";
            }
        }

    } while (c != ESCAPE);
}