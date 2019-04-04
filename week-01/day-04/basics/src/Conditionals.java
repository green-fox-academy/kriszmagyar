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


        // Party indicator
        System.out.print("Number of girls: ");
        int numbOfGirls = scanner.nextInt();

        System.out.print("Number of boys: ");
        int numbOfBoys = scanner.nextInt();

        boolean isEnoughPeople = numbOfGirls + numbOfBoys >= 20;
        boolean isGoodSexRatio = numbOfGirls / numbOfBoys == 1;

        String partyMsg;

        if (numbOfGirls == 0)                      partyMsg = "Sausage party!";
        else if (isEnoughPeople && isGoodSexRatio) partyMsg = "The party is excellent!";
        else if (isEnoughPeople)                   partyMsg = "Quite cool party!";
        else                                       partyMsg = "Average party...";

        System.out.println(partyMsg);


        // Conditional variable mutation
        double a = 24;
        int out = 0;
        if (a % 2 == 0) out++;
        System.out.println("out: " + out);

        int b = 13;
        String out2 = "";
        if (b >= 10 && b <= 20) out2 = "Sweet!";
        else if (b < 10)        out2 = "Less!";
        else                    out2 = "More!";
        System.out.println("out2: " + out2);

        int c = 123;
        int credits = 100;
        boolean isBonus = false;
        if (!isBonus) {
            if (credits >= 50) c -= 2;
            else               c --;
        }
        System.out.println("c: " + c);

        int d = 8;
        int time = 120;
        String out3 = "";
        if (d % 4 == 0 && time <= 200) out3 = "check";
        else if (time > 200)           out3 = "Time out";
        else                           out3 = "Run Forest Run!";
        System.out.println("out3: " + out3);

    }
}
