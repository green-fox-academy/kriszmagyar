public class Basics {

  public static void main(String[] args) {

    System.out.println(numberAdder(5)); // expects 15
    System.out.println(sumDigits(135)); // expects 9
    System.out.println(power(4, 2)); // expects 16
    System.out.println(commonDivisor(48, 18)); // expects 6
    System.out.println(multiBy(25, 2)); // expects 50
    System.out.println(countBunnyEars(10)); // expects 25
    System.out.println(replaceAll("my exes are xors", 'x', 'y')); // expects 'my eyes are yors'

  }

  /**
   * Write a recursive function that takes
   * one parameter: n and adds numbers from 1 to n.
   */
  private static int numberAdder(int num) {
    return num == 1 ? 1 : num + numberAdder(num - 1);
  }

  /**
   * Given a non-negative int n, return
   * the sum of its digits recursively (no loops).
   */
  private static int sumDigits(int num) {
    if (num / 10 == 0) {
      return num;
    } else {
      return num % 10 + sumDigits(num / 10);
    }
  }

  /**
   * Given base and n that are both 1 or more, compute
   * recursively (no loops) the value of base to the n power.
   */
  private static int power(int base, int exp) {
    if (exp == 1) {
      return base;
    } else {
      return base * power(base, exp - 1);
    }
  }

  /**
   * Find the greatest common divisor of two numbers using recursion.
   */
  private static int commonDivisor(int num1, int num2) {
    int max = Math.max(num1, num2);
    int min = Math.min(num1, num2);
    int remainder = max % min;

    if (remainder == 0) {
      return min;
    } else {
      return commonDivisor(min, remainder);
    }
  }

  /**
   * We have a number of bunnies and each bunny has two big
   * floppy ears. We want to compute the total number of ears
   * across all the bunnies recursively (without loops or multiplication).
   */
  private static int multiBy(int num, int multi) {
    if (num == 1) {
      return multi;
    } else {
      return multi + multiBy(num - 1, multi);
    }
  }

  /**
   * We have bunnies standing in a line, numbered 1, 2, ... The odd
   * bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..)
   * we'll say have 3 ears, because they each have a raised foot. Recursively
   * return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
   */
  private static int countBunnyEars(int num) {
    if (num == 1) {
      return 2;
    } else {
      return 3 - num % 2 + countBunnyEars(num - 1);
    }
  }

  /**
   * Given a string, compute recursively (no loops) a new string
   * where all the lowercase old chars have been changed to new chars.
   */
  private static String replaceAll(String str, char oldChar, char newChar) {
    String newStr = str.replace(oldChar, newChar);
    if (str.equals(newStr)) {
      return str;
    } else {
      return replaceAll(newStr, oldChar, newChar);
    }
  }

}
