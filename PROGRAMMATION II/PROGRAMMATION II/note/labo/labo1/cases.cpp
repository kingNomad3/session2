#include <iostream>
#include <iomanip>
#include <conio.h>

#include "cvm23.h"

enum Case
{
    CS, CD, CO, CF, CV
    // CS --> Case surprise (bleu)
    // CD --> Case dollars (vert)
    // CO --> Case ordinaire (bleu)
    // CF --> Case fragile (jaune)
    // CV --> Case vide (noir)
};

struct Style
{
    Color color; char c;
    // color --> Couleur de la case
    // c --> Caractère de la classe
};

using std::cout; using std::cin;
using std::setfill; using std::setw;

int main() {
    const size_t LARGEUR = 100, HAUTEUR = 30, CASE_X = 10, CASE_Y = 4;
    const Color MSG_COLOR = Color::gry;

    Style map[5] =
    {
           { Color::blu, '\xB2' },
           { Color::grn, '\x24' },
           { Color::blu, '\xB2' },
           { Color::yel, '\xB0' },
           { Color::blk, '\x00' }
    };

    setwsize(HAUTEUR, LARGEUR);

    setcolor(MSG_COLOR);
    gotoxy(CASE_Y, CASE_Y - 1);
    cout << "Affichage d'une case bleue";
    setcolor(map[CO].color);
    cout << setfill(map[CO].c);
    for (size_t i = 0; i < CASE_Y; i++)
    {
        gotoxy(CASE_Y, CASE_Y + i);
        cout << setw(CASE_X) << "";
    }

    setcolor(MSG_COLOR);
    gotoxy(CASE_Y, CASE_Y + 5);
    cout << "Affichage d'une case dollars";
    setcolor(map[CD].color);
    cout << setfill(map[CD].c);
    for (size_t i = 0; i < CASE_Y; i++)
    {
        gotoxy(CASE_Y, CASE_Y + 6 + i);
        cout << setw(CASE_X) << "";
    }

    setcolor(MSG_COLOR);
    gotoxy(CASE_Y, CASE_Y + 11);
    cout << "Affichage d'une case jaune";
    setcolor(map[CF].color);
    cout << setfill(map[CF].c);
    for (size_t i = 0; i < CASE_Y; i++)
    {
        gotoxy(CASE_Y, CASE_Y + 12 + i);
        cout << setw(CASE_X) << "";
    }

    setcolor(MSG_COLOR);
    gotoxy(CASE_Y, CASE_Y + 17);
    cout << "Affichage d'une case noire";
    setcolor(map[CV].color);
    cout << setfill(map[CV].c);
    for (size_t i = 0; i < CASE_Y; i++)
    {
        gotoxy(CASE_Y, CASE_Y + 17 + i);
        cout << setw(CASE_X) << "";
    }

    setcolor(Color::red);
    gotoxy(0, HAUTEUR - 3);
    cout << "Appuyez sur une touche pour sortir.";
    _getch();
}