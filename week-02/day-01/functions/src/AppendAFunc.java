public class AppendAFunc {

  public static void main(String[] args) {
    String typo = "Chinchill";
    System.out.println(appendAFunc(typo)); // expects Chinchilla
  }

  public static String appendAFunc(String txt) {
    return txt + "a";
  }

}
