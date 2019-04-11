public class Basics {

  public static void main(String[] args) {

    System.out.println(numberAdder(5)); // expects 15
    System.out.println(sumDigits(135)); // expects 9
    System.out.println(power(4, 2)); // expects 16

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

}
