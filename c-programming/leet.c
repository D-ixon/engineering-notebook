#include <stdio.h>

int main(){
    int arr[5] = {50, 8, 7, 0, 1};
    int target = 100;

    for (int i = 0; i < 5; i++) {
        for (int j = i + 1; j < 5; i++){
            if (arr[i] + arr[j] == target){
                printf("Indices %d, %d", i, j);
                return 0;
            }
        }
    }
    printf("no pair found/n");
    return 0;
}