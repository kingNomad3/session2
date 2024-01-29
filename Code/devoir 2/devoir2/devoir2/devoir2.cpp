
#include <iostream>

using namespace std;

struct Vecteur {
	float x;
	float y;
	float z;
};

struct Quaternion {
	float x;
	float y;
	float z;
	float w;
};

struct Transforme {
	Vecteur position;
	Quaternion rotation;
	Vecteur scale;//grosseur
};

Vecteur addition(Vecteur a, Vecteur b) {
	Vecteur position;
	position.x = a.x + b.x;
	position.y = a.y + b.y;
	position.z = a.z + b.z;
	return position;
}

Vecteur scalaire_mult(Vecteur a, float s) {
	Vecteur mul;
	mul.x = a.x * s;
	mul.y = a.y * s;
	mul.z = a.z * s;
	return mul;
}

float scalaire_produit(Vecteur a, Vecteur b) {
	float SP = a.x * b.x + a.y * b.y + a.z * b.z;
	return SP;
}

int main() {
	Vecteur v1 = { 1, 2, 3 };
	Vecteur v2 = { 4, 5, 6 };
	Quaternion q = { 1.5, 1, 1, 1.5 };
	Transforme t = { v1, q, v2 };

	Vecteur v3 = addition(v1, v2);
	Vecteur v4 = scalaire_mult(v1, 2);
	float PS = scalaire_produit(v1, v2);

	cout << "Addition des vecteurs a et b = (" << v3.x << ", " << v3.y << ", " << v3.z << ")" << endl;
	cout << "Multiplication par un scalaire (nombre réel) = (" << v4.x << ", " << v4.y << ", " << v4.z << ")" << endl;
	cout << "Produit scalaire de deux vecteurs = " << PS << endl;


}