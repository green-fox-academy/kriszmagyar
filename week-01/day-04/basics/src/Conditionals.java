import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Odd even
        System.out.print("Give me a number: ");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }


        // One two a lot
        System.out.print("Give me a number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Not enough");
        } else if (number == 1) {
            System.out.println("One");
        } else if (number == 2) {
            System.out.println("Two");
        } else {
            System.out.println("A lot");
        }


        // Print bigger
        System.out.print("x: ");
        int x = scanner.nextInt();

        System.out.print("y: ");
        int y = scanner.nextInt();

        if (x > y) {
            System.out.println(x);
        } else if (y > x) {
            System.out.println(y);
        } else {
            System.out.println("The numbers are equal!");
        }

    }
}
