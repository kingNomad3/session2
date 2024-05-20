#include <iostream>
using namespace std;

int Facto(int n) {
	// n! = n * (n - 1)!
	// Si n = 1 => 1
	if (n == 1)
		return 1;
	else
		return n * Facto(n - 1);
}

long long Fibo(int n) {
	cout << n << "\n";
	if (n < 2) return n;
	/*if (n == 1) return 1;
	else if (n == 0) return 0;*/
	else
		return Fibo(n - 1) + Fibo(n - 2);
}

int main() {
	//cout << Facto(4);
	cout << Fibo(60);
}