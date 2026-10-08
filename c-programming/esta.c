#include <stdio.h>

void printThreeStrings(char str1[], char str2[], char str3[]) {
    printf("String 1: %s\n", str1);
    printf("String 2: %s\n", str2);
    printf("String 3: %s\n", str3);
}

int main(void) {
    // Three string variables in main
    char var1[] = "Hello";
    char var2[] = "C World";
    char var3[] = "Programming";

    // Call the void function using the variables as arguments
    printThreeStrings(var1, var2, var3);

    return 0;
}