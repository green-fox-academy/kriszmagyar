import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Practice {

  public static void main(String[] args) {

    divide(0); // excepts fail
    printFromFile("assets/my-file.txt");

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
      List <String> lines =  Files.readAllLines(Paths.get(path));
      for (String line : lines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Unable to read file: " + path);
    }
  }

}
