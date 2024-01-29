#include "..\cvm 21.h"
#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>
#include  <math.h>

using namespace std;



int main() {

    //int x = 0;
    //int y = 0;
    //char i;
    const int colonnes = 3;
    const int ligne = (256 - 34 + 1) / colonnes;
    int current =0;



    for (int i = 34; i <= 255; i++) {

        for (int j = 0; j < colonnes; j++) {
            if (current <= 256) {
                current = i + j;
                cout << "La valeur de la table ASCII de " << (char)i << " est " << i << " (decimale), ";
                cout << oct << setw(3) << setfill('0') << i << " (octalee), ";
                cout << hex << setw(2) << setfill('0') << i << " (hexadecimale)" << endl;



            }
        }
    }
}

