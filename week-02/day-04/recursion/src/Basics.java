public class Basics {

  public static void main(String[] args) {

    System.out.println(numberAdder(5)); // expects 15
    System.out.println(sumDigits(135)); // expects 9

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

}
