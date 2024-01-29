
// Ajouter les autres includes ici
#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>
#include <graphcis>
#include "..\cvm23.h"

// PRAGMA
#pragma warning (disable:6031)		// valeur de retour ignorée '_getch'
#pragma warning (disable:26812)		// type enum 'type-name' est non délimité. Préférez 'enum class' à 'enum' (enum.3)

using std::cout;
using namespace std;
//variable et constant
int casex = 6;
int casey = 3;
int y = 0, x = 0;
int h = 0;
int s = 0;

uint8_t c;
Position  fleche = { 3, 3 };

// Ajouter les consts ici de la forme :
// const <type> <nom> = <valeur>;

const size_t LARGEUR = 100, HAUTEUR = 50;
const uint8_t ESCAPE = 27; // Valeur de la touche échapée pour sortir
// Caractéristique des cases
const size_t LIG = 8, COL = 12;
// Position de départ
const size_t START_X = -1;
const size_t START_Y = -1;
const Color curseur = Color::gry;


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
    // c --> Caractère de la classe
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

// Représente un déplacement

struct Coordonne_s {

};
struct Move
{
    Position from, to;
};

// Curseur
char cursor[5][6] =
{
    { '\xC9', '\xCD','\xCD','\xCD','\xCD', '\xBB' },
    { '\xBA', '\x00','\x00','\x00','\x00', '\xBA' },
    { '\xC8', '\xCD','\xCD','\xCD','\xCD', '\xBC' }
};

// utiliser un if else pour changer les cases voir l'exemple des cases if position du curseur == la position du bleu setcolour(CS). Je dois afficher 2 fois le damier 

int main() {
    //setwsize(WIN_Y, WIN_X);
    //show(false); // Désactive l'affichage du curseur

    uint8_t c;
    //fleche = wherexy();
    //setcp(1252);

    //setwsize(LARGEUR, HAUTEUR);


    Move m;
    m.from = { 0, 0 };

    clrscr();
    // affiche le damier
    for (int e = 0; e < 12; e++) {
        for (int a = 0; a <= 7; a++) {
            gotoxy(x, y);
            setcolor(map[damier[a][e]].color);
            cout << setfill(map[damier[a][e]].c);
            for (size_t i = 0; i < casey; i++)
            {
                gotoxy(casey + s, casey + i + h);
                cout << setw(casex) << "";
            }
            h += 4;
        }
        s += 8;
        h = 0;
    }
    do {
        
        
        if (_kbhit()) {
            c = _getch();

            h = 0;
            s = 0;
        
            // affiche le damier
            for (int e = 0; e < 12; e++) {
                for (int a = 0; a <= 7; a++) {
                    gotoxy(x, y);
                    setcolor(map[damier[a][e]].color);
                    cout << setfill(map[damier[a][e]].c);
                    for (size_t i = 0; i < casey; i++)
                    {
                        gotoxy(casey + s, casey + i + h);
                        cout << setw(casex) << "";
                    }
                    h += 4;

                    
                }
                s += 8;
                h = 0;
            }

            //curseur 
           
             
            cout << ", " << c << "(" << (int)c << ")";
            // affiche le curseur 
            for (int a = 0; a < casey; a++) {
                gotoxy(fleche.x, fleche.y + a);
                setcolor(curseur);
                for (int i = 0; i < casex; i++)
                {
                    if (curseur = map[CV].color) {

                        cout << cursor[a][i] << "";

                        setcolor(map[damier[a][i]].color);

                        if (getcolor() == map[damier[a][i]].color) {
                            setcolor(map[CD].color);
                        }
                    }
                }
                }

               
            }

            
            switch (ArrowKeys(c)) // On converti le caractère dans l'énumération
            {
            case ArrowKeys::UP_LEFT:
                fleche.y -= 4;
                break;
            case ArrowKeys::UP_RIGHT:
                fleche.y -= 4;
                fleche.x += 8;
                break;
                fleche.x -= 8;
            case ArrowKeys::UP:
                fleche.y -= 4;
                
                break;
            case ArrowKeys::LEFT:
                fleche.x -= 8;
                break;
            case ArrowKeys::RIGHT:
                fleche.x += 8;
                break;
            case ArrowKeys::DOWN_LEFT:
                fleche.y += 4;
                fleche.x -= 8;
                break;
            case ArrowKeys::DOWN:
                fleche.y += 4;
               
               
                    
                
                break;
            case ArrowKeys::DOWN_RIGHT:
                fleche.y += 4;
                fleche.x += 8;
                break;

            
            }
        }
        
    

    c = _getch();
} while (c != ESCAPE);


// Continuer ici
}