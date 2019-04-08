public class Greet {

  public static void main(String[] args) {
    String al = "GreenFox";
    greet(al); // expects print Greetings dear, GreenFox
  }

  public static void greet(String name) {
    System.out.println("Greetings dear, " + name);
  }

}
