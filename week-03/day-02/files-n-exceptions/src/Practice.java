public class Practice {

  public static void main(String[] args) {

    divide(0); // excepts fail

  }

  private static void divide(int n) {
    try {
      System.out.println(10 / n);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }

}
