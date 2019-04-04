import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        // Note: Some tasks require user inputs, I omit that
        // because it is easier to test this way.

        // I wont cheat on exams
        for (int i = 0; i < 100; i++) {
            System.out.println("I won't cheat on exam!");
        }

        // Print even
        for (int i = 2; i < 500; i += 2) {
            System.out.println(i);
        }

        // Multiplication table
        int num = 15;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + num + " = " + (i * num));
        }

        // Count from to
        int first  = 3;
        int second = 6;

        if (second <= first) {
            System.out.println("The second number should be bigger");
        } else {
            for (int i = first; i < second; i++) {
                System.out.println(i);
            }
        }

        // FizzBuzz
        for (int i = 1; i < 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        // Triangle
        int numbOfRows = 4;
        for (int i = 1; i <= numbOfRows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Draw diagonal
        numbOfRows = 10;
        for (int i = 1; i <= numbOfRows; i++) {
            for (int j = 1; j <= numbOfRows; j++) {

                if (i == 1 || i == numbOfRows || j == 1 || j == numbOfRows || i == j) {
                    System.out.print("%");
                }  else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

        // Guess the number
        Scanner scanner = new Scanner(System.in);
        int solution = 8;

        System.out.println("Try to guess the number!");
        while (true) {
            int answer = scanner.nextInt();

            if (solution > answer) {
                System.out.println("The stored number is higher");
            } else if (solution < answer) {
                System.out.println("The solution is lower");
            } else {
                System.out.println("You found the number: " + solution);
                break;
            }
        }

    }
}
