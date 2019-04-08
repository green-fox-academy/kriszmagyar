public class Factorial {

  public static void main(String[] args) {
    System.out.println(factorio(4)); // expects 24
  }

  public static int factorio(int num) {
    int result = 1;
    for (int i = 1; i <= num; i++) {
      result *= i;
    }
    return result;
  }

}
