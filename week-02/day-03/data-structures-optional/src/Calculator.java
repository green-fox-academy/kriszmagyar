import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {

    // Create a simple calculator application which reads the parameters from the prompt
    // and prints the result to the prompt.
    // It should support the following operations,
    // create a method named "calculate()":
    // +, -, *, /, % and it should support two operands.
    // The format of the expressions must be: {operation} {operand} {operand}.
    // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

    // You can use the Scanner class
    // It should work like this:

    // Start the program
    // It prints: "Please type in the expression:"
    // Waits for the user input
    // Print the result to the prompt
    // Exit

    start();

  }

  private static void start() {
    System.out.println("Write expression, like '+ 1 1'\nWrite 'exit' to exit");

    while (true) {
      String[] input = getInput().split(" ");
      if (input[0].equals("exit")) {
        break;
      }

      System.out.println(getResult(input));
    }
  }

  private static String getInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private static double getResult(String[] input) {
    char operation = input[0].charAt(0);
    int num1 = Integer.parseInt(input[1]);
    int num2 = Integer.parseInt((input[2]));
    return calculate(operation, num1, num2);
  }

  private static double calculate(char operation, int num1, int num2) {
    switch (operation) {
      case '+': return num1 + num2;
      case '-': return num1 - num2;
      case '*': return num1 * num2;
      case '/':
      case ':': return num1 / num2;
      case '%': return num1 % num2;
      default: return 0;
    }
  }

}
