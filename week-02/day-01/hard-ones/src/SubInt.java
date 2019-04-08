import java.util.Arrays;

public class SubInt {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(subInt(1, new int[]{1, 11, 34, 52, 61}))); //  should print: `[0, 1, 4]`
    System.out.println(Arrays.toString(subInt(9, new int[]{1, 11, 34, 52, 61}))); //  should print: '[]'
    System.out.println(Arrays.toString(subInt(3, new int[]{1, 11, 34, 52, 61}))); //  should print: '[2]'

  }

  /**
   * Returns the indices of the integers in the array of which the first number is a part of
   * Or returns an empty array if the number is not part of any of the integers in the array
   */
  private static int[] subInt(int sub, int[] arr) {
    int[] results = new int[arr.length];
    int numbOfSubs = 0;

    for (int i = 0; i < arr.length; i++) {
      if (isContainsDigit(arr[i], sub)) {
        results[numbOfSubs++] = i;
      }
    }

    return Arrays.copyOf(results, numbOfSubs);
  }

  /**
   * Returns true if the input numbers contains a specific digit
   */
  private static boolean isContainsDigit(int num, int digit) {
    return String.valueOf(num).contains(String.valueOf(digit));
  }

}
