#include <stdio.h>

// Optimized modern version of Euclid's algorithm
int gcd(int u, int v) {
    while (v != 0) {
        int t = u % v;
        u = v;
        v = t;
    }
    return u;
}

int main(void) {
    int x, y;
    
    // Read input until End-Of-File (EOF)
    while (scanf("%d %d", &x, &y) != EOF) {
        if (x > 0 && y > 0) {
            printf("%d %d %d\n", x, y, gcd(x, y));
        }
    }
    
    return 0;
}