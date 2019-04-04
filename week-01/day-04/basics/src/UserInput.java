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


        // Animals and legs
        System.out.print("Number of chickens: ");
        int numbOfChickens = scanner.nextInt();

        System.out.print("Number of pigs: ");
        int numbOfPigs = scanner.nextInt();

        int numbOfLegs = numbOfChickens * 2 + numbOfPigs * 4;
        System.out.println("The total number of legs: " + numbOfLegs);

    }
}
