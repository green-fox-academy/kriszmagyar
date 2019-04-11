public class Basics {

  public static void main(String[] args) {

    System.out.println(numberAdder(5)); // expects 15
    System.out.println(sumDigits(135)); // expects 9
    System.out.println(power(4, 2)); // expects 16
    System.out.println(commonDivisor(48, 18)); // expects 6
    System.out.println(multiBy(25, 2)); // expects 50

  }

  private static int numberAdder(int num) {
    return num == 1 ? 1 : num + numberAdder(num - 1);
  }

  private static int sumDigits(int num) {
    if (num / 10 == 0) {
      return num;
    } else {
      return num % 10 + sumDigits(num / 10);
    }
  }

  private static int power(int base, int exp) {
    if (exp == 1) {
      return base;
    } else {
      return base * power(base, exp - 1);
    }
  }

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

  private static int multiBy(int num, int multi) {
    if (num == 1) {
      return multi;
    } else {
      return multi + multiBy(num - 1, multi);
    }
  }

}
