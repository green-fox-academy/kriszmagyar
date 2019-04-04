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

    }
}
