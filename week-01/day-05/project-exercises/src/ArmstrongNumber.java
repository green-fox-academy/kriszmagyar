import java.util.ArrayList;

public class ArmstrongNumber {
    public static void main(String[] args) {

        // An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits.

        int num = 153;
        System.out.println(isArmstrongNumber(num)); // expects true

        num = 1634;
        System.out.println(isArmstrongNumber(num)); // expects true

        num = 371;
        System.out.println(isArmstrongNumber(num)); // expects true

        num = 111;
        System.out.println(isArmstrongNumber(num)); // expects false

    }

    private static boolean isArmstrongNumber(int num) {
        ArrayList<Integer> digits = new ArrayList<>();

        // Get the digits into a list array
        int numCopy = num;
        while (numCopy > 0) {
            digits.add(numCopy % 10);
            numCopy /= 10;
        }

        // Calculate the result
        int numbOfDigits = digits.size();
        int result = 0;

        for (int i = 0; i < numbOfDigits; i++) {
            result += powerInt(digits.get(i), numbOfDigits);
        }

        return result == num;
    }

    private static int powerInt(int num, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= num;
        }
        return result;
    }

}
