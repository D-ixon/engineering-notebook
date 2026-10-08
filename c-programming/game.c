#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int secret_number;
    int guess;
    int attempts = 0;

    // Seed the random number generator using the current time
    srand(time(NULL));

    // Generate a random number between 1 and 100
    secret_number = (rand() % 100) + 1;

    printf("===================================\n");
    printf("   Welcome to the Guessing Game!   \n");
    printf("===================================\n");
    printf("I have chosen a number between 1 and 100.\n");
    printf("Can you guess what it is?\n\n");

    // Loop until the user guesses the correct number
    do {
        printf("Enter your guess: ");
        
        // Read user input and validate it is a number
        if (scanf("%d", &guess) != 1) {
            printf("Invalid input! Please enter a valid number.\n");
            
            // Clear the input buffer to prevent an infinite loop on bad input
            while (getchar() != '\n');
            continue;
        }

        attempts++;

        // Evaluate the user's guess
        if (guess > secret_number) {
            printf("Too high! Try a lower number.\n\n");
        } else if (guess < secret_number) {
            printf("Too low! Try a higher number.\n\n");
        } else {
            printf("\n🎉 Congratulations! You guessed it right!\n");
            printf("The secret number was %d.\n", secret_number);
            printf("It took you %d attempts to win.\n", attempts);
        }

    } while (guess != secret_number);

    return 0;
}
