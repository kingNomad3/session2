#include <iostream>
// Ajouter les autres includes ici

#include "cvm23.h"

// PRAGMA
#pragma warning (disable:6031)		// valeur de retour ignor�e '_getch'
#pragma warning (disable:26812)		// type enum 'type-name' est non d�limit�. Pr�f�rez 'enum class' � 'enum' (enum.3)

using std::cout;

// Position de d�part
const size_t START_X = -1;
const size_t START_Y = -1;

// Caract�ristique des cases
const size_t LIG = 8, COL = 12;
// Ajouter les consts ici de la forme :
// const <type> <nom> = <valeur>;

enum class ArrowKeys
{
    UP_LEFT = 71, UP = 72, UP_RIGHT = 73,
    LEFT = 75, RIGHT = 77,
    DOWN_LEFT = 79, DOWN = 80, DOWN_RIGHT = 81
};

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
    // c --> Caract�re de la classe
};

// Style des cases
Style map[5] =
{
       { Color::blu, '\xB2' },
       { Color::grn, '\x24' },
       { Color::blu, '\xB2' },
       { Color::yel, '\xB0' },
       { Color::blk, '\x00' }
};

// Damier initial
Case damier[LIG][COL] =						// le damier et ses cases initiales
{
    { CO, CO, CO, CO, CO, CO, CO, CO, CV, CO, CO, CS },
    { CO, CO, CV, CV, CO, CO, CO, CO, CO, CV, CO, CV },
    { CO, CO, CV, CS, CV, CO, CO, CO, CO, CO, CV, CS },
    { CO, CO, CV, CS, CV, CO, CO, CV, CV, CO, CV, CS },
    { CS, CO, CV, CV, CV, CS, CV, CO, CV, CO, CV, CO },
    { CS, CO, CS, CS, CO, CS, CV, CS, CV, CO, CV, CO },
    { CS, CO, CS, CO, CO, CO, CV, CV, CV, CO, CV, CO },
    { CS, CS, CO, CO, CO, CO, CO, CO, CO, CO, CO, CO }
};

// Repr�sente un d�placement
struct Move
{
    Position from, to;
};

// Curseur
char cursor[3][3] =	
{
    { '\xC9', '\xCD', '\xBB' },
    { '\xBA', '\x00', '\xBA' },
    { '\xC8', '\xCD', '\xBC' }
};

int main() {
    setwsize(WIN_Y, WIN_X);
    show(false); // D�sactive l'affichage du curseur

    Move m;
    m.from = { 0, 0 };

    // Continuer ici
}