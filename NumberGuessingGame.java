package org.example;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 0;
        int lower = 1;
        int upper = 100;
        int attempts = 5;

        while (true) {
            System.out.println("Welcome to the game!");
            System.out.println("Enter the number of rounds you want to play:");
            rounds = scanner.nextInt();
            if (rounds < 0) {
                System.out.println("Invalid input. Exiting the game");
                break;
            }
            int score = 0;
            for (int i = 0; i < rounds; i++) {
                System.out.printf("--- Round %d ---\n", i + 1);
                int number = random.nextInt(upper - lower + 1) + lower;
                System.out.printf("I'm thinking of a number between %d and %d... \n", lower, upper);
                int j;
                for (j = 0; j < attempts; j++) {
                    System.out.printf("Enter your guess (attempt %d/%d): ", j + 1, attempts);
                    int guess = scanner.nextInt();
                    if (guess < number) {
                        System.out.println("Too low!");
                    } else if (guess > number) {
                        System.out.println("Too high!");
                    } else {
                        System.out.printf("Congratulations! You guessed the number in %d attempts!\n", j + 1);
                        score++;
                        break;
                    }
                }
                if (j == attempts) {
                    System.out.printf("Sorry, you didn't guess the number in the allotted attempts. The number was %d.\n", number);
                }
            }
            double percentage = (double) score / rounds * 100;
            System.out.printf("Your final score is %d/%d (%.1f%%)\n",score, rounds, percentage);
            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")){
                break;
            }
        }
        scanner.close();
    }
}