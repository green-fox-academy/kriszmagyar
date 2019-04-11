public class Basics {

  public static void main(String[] args) {

    System.out.println(numberAdder(5)); // expects 15

  }

  private static int numberAdder(int num) {
    return num == 1 ? 1 : num + numberAdder(num - 1);
  }


}
