#include <iostream>
#include <iomanip>
#include <conio.h>
#include <string>


using namespace std;



int main() {
    const string chara = "charactere";
    const string deci = " decimale ";
    const string hexa = " hexadecimale ";
    const string octa = " octale ";
   

    
        for ( int i = 34, j =74, k = 114; i <= 255; i += 40, j += 40, k += 40) {
            //for (int j = 74; j < 149; j++) {
                cout << setw(2) << chara << setw(13) << deci << octa << hexa << setw(15) << chara << setw(13) << deci << octa << hexa << setw(15) << chara << setw(13) << deci << octa << hexa << endl;
                cout << setw(5) << (char)i << setw(13) << i << oct << setw(10) << i << hex << setw(13) << i << setw(15) << (char)j << setw(12) << j << oct << setw(10) << j << hex << setw(13) << j << setw(13) << (char)k << setw(13) << k << oct << setw(10) << k << hex << setw(10) << k << endl;

            //}
        }

        
}

#include <iostream>
#include <conio.h>


using namespace std;





int main() {

    struct Couleur {
        unsigned int r, v, b, a;

    };

    const Couleur COULEUR_ROUGE[4] = { 255, 0, 0, (float)1.0f };
    const Couleur COULEUR_VERT[4] = { 0, 255, 0, (float)1.0f };
    const Couleur COULEUR_BLEU[4] = { 0, 0, 255, (float)1.0f };

    const int LIG = 3, COL = 3;
    Couleur image[LIG][COL];


    for (int i = 0; i < LIG; i++) {
        for (int j = 0; j < COL; j++) {
            cout << "Entrer la couleur de la facon suivante 0 0 0 0  à  la position(" << i << ", " << j << "), puis enter: ";
            cin >> image[i][j].r;
            cin >> image[i][j].v;
            cin >> image[i][j].b;
            cin >> image[i][j].a;
        }
    }

    Couleur Retirer;
    cout << "Retirer la couleur ";
    cin >> Retirer.r >> Retirer.v >> Retirer.b >> Retirer.a;

    for (int i = 0; i < LIG; i++) {
        for (int j = 0; j < COL; j++) {
            unsigned int newR = image[i][j].r - Retirer.r;
            unsigned int newV = image[i][j].v - Retirer.v;
            unsigned int newB = image[i][j].b - Retirer.b;
            unsigned int newA = (float)image[i][j].a - (float)Retirer.a;
            image[i][j] = { newR, newV, newB, newA };
        }
    }

    cout << "Resulta:" << endl;
    for (int i = 0; i < LIG; i++) {
        for (int j = 0; j < LIG; j++) {
            cout << image[i][j].r << " " << image[i][j].v << " " << image[i][j].b << " " << image[i][j].a << endl;
        }
    }

    _getch();
}