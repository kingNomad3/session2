#include <iostream>

using std::cout;

struct Vecteur2_s {
	float x;
	float y;
};

// void operator<<(std::ostream& stream, const Vecteur2_s& vecteur);
std::ostream& operator<<(std::ostream& stream, const Vecteur2_s& vecteur);

Vecteur2_s operator+(const Vecteur2_s& a, const Vecteur2_s& b);
Vecteur2_s operator*(const Vecteur2_s& a, const float& s);
Vecteur2_s operator*(const float& s, const Vecteur2_s& a);
Vecteur2_s operator-(const Vecteur2_s& a, const Vecteur2_s& b);

void operator+=(Vecteur2_s& a, const Vecteur2_s& b);
void operator-=(Vecteur2_s& a, const Vecteur2_s& b);

bool operator==(const Vecteur2_s& a, const Vecteur2_s& b);
bool operator!=(const Vecteur2_s& a, const Vecteur2_s& b);

int main() {
	Vecteur2_s a = { 1, 3 }, b = { 1, 3 }, c;

	cout << "(" << a.x << ", " << a.y << ")\n";
	cout << a << "\n";
	cout << b.x << "\n";

	c = a + b;
	cout << c << "\n";
	cout << c * 2 << "\n";
	cout << a - b << "\n";

	a += b;
	cout << a << "\n";
	a -= b;
	cout << a << "\n";
	cout << (a == b);
}

//void operator<<(std::ostream& stream, const Vecteur2_s& vecteur) {
//	stream << "(" << vecteur.x << ", " << vecteur.y << ")";
//}

std::ostream& operator<<(std::ostream& stream, const Vecteur2_s& vecteur) {
	stream << "(" << vecteur.x << ", " << vecteur.y << ")";
	return stream;
}

Vecteur2_s operator+(const Vecteur2_s& a, const Vecteur2_s& b) {
	Vecteur2_s c{};
	c.x = a.x + b.x;
	c.y = a.y + b.y;
	return c;
}

Vecteur2_s operator*(const Vecteur2_s& a, const float& s) {
	return { s * a.x, s * a.y };
}

Vecteur2_s operator*(const float& s, const Vecteur2_s& a) {
	return a * s;
}

Vecteur2_s operator-(const Vecteur2_s& a, const Vecteur2_s& b) {
	return a + (b * -1);
}

// a += b
void operator+=(Vecteur2_s& a, const Vecteur2_s& b) {
	a = a + b;
}

// a -= b
void operator-=(Vecteur2_s& a, const Vecteur2_s& b) {
	a = a - b;
}
bool operator!=(const Vecteur2_s& a, const Vecteur2_s& b) {
	return !(a == b);
}

bool operator==(const Vecteur2_s& a, const Vecteur2_s& b) {
	return a.x == b.x && a.y == b.y;
}