import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Practice {

  public static void main(String[] args) {

    divide(0); // excepts fail
    printFromFile("assets/my-file.txt"); // excepst to print all lines
    System.out.println(numbOfLines("assets/my-file.txt")); // excepts 3

  }

  private static void divide(int n) {
    try {
      System.out.println(10 / n);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }

  private static void printFromFile(String path) {
    try {
      List<String> lines =  Files.readAllLines(Paths.get(path));
      for (String line : lines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Unable to read file: " + path);
    }
  }

  private static int numbOfLines(String path) {
    try {
      return Files.readAllLines(Paths.get(path)).size();
    } catch (IOException e) {
      return 0;
    }
  }

}
