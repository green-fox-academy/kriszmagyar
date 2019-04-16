import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Decryption {

  public static void main(String[] args) {

    print(decryptDoubledMsg("assets/duplicated-chars.txt"));

  }

  private static List<String> decryptDoubledMsg(String path) {

    List<String> msg = getMsg(path);
    List<String> decryptedMsg = new ArrayList<>();

    for (String line : msg) {
      decryptedMsg.add(decryptLine(line));
    }

    return decryptedMsg;
  }

  private static List<String> getMsg(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static String decryptLine(String line) {
    StringBuilder sb = new StringBuilder(line);
    for (int i = 0; i < line.length() / 2; i++) {
      sb.delete(i + 1, i + 2);
    }
    return sb.toString();
  }

  private static void print(List<String> txt) {
    for (String line : txt) {
      System.out.println(line);
    }
  }

}
