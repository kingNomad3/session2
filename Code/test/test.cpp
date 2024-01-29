#include <iostream>
using namespace std;
int main(void) {
    int n, p = 5;
    n = foo(p);
    cout << "p = " << p << "; n = " << n;
}
int foo(int r) {
    return 2 * r;
}