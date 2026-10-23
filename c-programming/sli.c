#include <stdio.h>

double rollover(){
    double win;
    for (int i = 10; i <= 10; i++){
        win = i * 1.5;
    }
    return win;
}   

int main(){

    printf("%f", rollover());
}