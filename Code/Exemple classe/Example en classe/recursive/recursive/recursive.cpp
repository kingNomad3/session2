#include <iostream>
#include <iomanip>
#include <conio.h>
using namespace std;


long long Godf(int n) {

	

	if (n == 0) {
		return 0;
	}
	else if (n < 0) {
		return Godf(-1 * n);
	}
	else if (n >= 1 && n <= 9) {
		return n + 1;

	}
	else if (n >= 10) {

		return Godf(n - 1) + Godf(n - 2) + 2 *Godf(n - 3);
	}

}

int main() {

	cout << Godf(10) << endl;
	cout << Godf(-10) << endl;
	cout << Godf(2) << endl;

	_getch();

}