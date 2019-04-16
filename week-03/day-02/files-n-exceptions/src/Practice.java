import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Practice {

  public static void main(String[] args) {

    divide(0); // excepts fail
    printFromFile("assets/my-file.txt"); // excepst to print all lines
    System.out.println(numbOfLines("assets/my-file.txt")); // excepts 3
    writeLineToFile("assets/my-name.txt", "Krisz"); // excepts to write Krisz to file
    writeMultiLinesToFile("assets/names.txt", "Im a line", 5); // excepts to write 5 lines to a file

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

  private static void writeLineToFile(String path, String name) {
    try {
      List<String> names = new ArrayList<>();
      names.add(name);
      Files.write(Paths.get(path), names);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + path);
    }
  }

  private static void writeMultiLinesToFile(String path, String line, int numbOfLines) {

    List<String> lines = new ArrayList<>();
    for (int i = 0; i < numbOfLines; i++) {
      lines.add(line);
    }

    try {
      Files.write(Paths.get(path), lines);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + path);
    }
  }

}
