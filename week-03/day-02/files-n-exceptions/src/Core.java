import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Core {

  public static void main(String[] args) {

    System.out.println(copyFiles("assets/copyFrom.txt", "assets/copyTo.txt")); // excepts to copy successfully

  }

  private static boolean copyFiles(String from, String to) {
    try {
      List<String> lines = Files.readAllLines(Paths.get(from));
      Files.write(Paths.get(to), lines);
      return true;
    } catch (IOException e) {
      return false;
    }
  }

}
