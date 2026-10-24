#include <stdio.h>
#include <stdlib.h> // Required for malloc and free

int main() {
    int iterations = 10;
    
    double *arr = (double *)malloc(iterations * sizeof(double));
    
    if (arr == NULL) {
        printf("Memory allocation failed!\n");
        return 1;
    }

    arr[0] = 10.0; 

    for (int i = 0; i < iterations; i++) {
        if (i < iterations - 1) {
            arr[i + 1] = arr[i] * 1.5;
        }
        
        printf("Element %d: %f\n", i, arr[i]);
    }

    free(arr);

    return 0;
}
