#include <iostream>

using namespace std;

long long Godefroy(int n) {
	if (n < 0)
		return Godefroy(-n);
	else if (n < 1)
		return 0;
	else if (n <= 9)
		return n + 1;
	else
		return Godefroy(n - 1) + Godefroy(n - 2) + 2 * Godefroy(n - 3);
}

int main() {
	cout << Godefroy(10) << "\n"
		<< Godefroy(-10) << "\n"
		<< Godefroy(2) << "\n";
}