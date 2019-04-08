public class Sum {

  public static void main(String[] args) {
    System.out.println(sum(5)); // expects 15
  }

  public static int sum(int num) {
    int result = 0;
    for (int i = 0; i <= num; i++) {
      result += i;
    }
    return result;
  }

}
