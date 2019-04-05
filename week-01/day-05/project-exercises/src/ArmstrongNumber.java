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
        ArrayList<Integer> digits = getDigitsList(num);
        int result = getSumDigitsOnPower(digits);
        return result == num;
    }

    private static ArrayList<Integer> getDigitsList(int num) {
        ArrayList<Integer> results = new ArrayList<>();

        while (num > 0) {
            results.add(num % 10);
            num /= 10;
        }

        return results;
    }

    private static int getSumDigitsOnPower(ArrayList<Integer> digits) {
        int numbOfDigits = digits.size();
        int result = 0;

        for (Integer digit : digits) {
            result += powerInt(digit, numbOfDigits);
        }

        return result;
    }

    private static int powerInt(int num, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= num;
        }
        return result;
    }

}
