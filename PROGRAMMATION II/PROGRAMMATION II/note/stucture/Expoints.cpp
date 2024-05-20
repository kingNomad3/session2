#include <iostream>
#include <cmath>
using namespace std;

struct Point_s {
	int x;
	int y;
};

void main(void) {
	Point_s A, B;
	A.x = 5;
	A.y = 3;
	B.x = 5;
	B.y = 12;

	float Distance;
	Distance = sqrt(pow(B.x - A.x, 2) + pow(B.y - A.y, 2));

	cout << "La distance entre A (" << A.x << ", " << A.y << ") et B ("
		<< B.x << ", " << B.y << ") est " << Distance << ".";
}