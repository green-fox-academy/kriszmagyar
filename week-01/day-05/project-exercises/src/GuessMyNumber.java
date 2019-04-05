import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {

        int lower = 1;
        int upper = 100;

        int maxLives = 5;
        int currentLives = maxLives;

        int solution = (int) (Math.random() * (upper - lower) + lower);

        System.out.println("I've the number between " + lower + "-" + upper + ". You have " + currentLives + " lives.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int guess = scanner.nextInt();

            if (guess > solution) {
                System.out.print("Too high.");
                currentLives = looseLife(currentLives);
            }

            if (guess < solution) {
                System.out.print("Too low.");
                currentLives = looseLife(currentLives);
            }

            if (guess == solution) {
                System.out.println("Congratulations. You won!");
                break;
            }

            if (currentLives <= 0) {
                System.out.println("You have no life left. You lost!");
                break;
            }

        }

    }

    private static int looseLife(int currentLives) {
        currentLives--;
        System.out.println(" You have " + currentLives + " lives left.");
        return currentLives;
    }

}
