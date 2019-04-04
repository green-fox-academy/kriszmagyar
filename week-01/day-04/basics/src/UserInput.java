import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Hello user
        System.out.println("Enter your name!");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);


        // Mile to km converter
        System.out.print("Km: ");
        int distance = scanner.nextInt();
        System.out.println("Mile: " + distance * 1.609344);

    }
}
