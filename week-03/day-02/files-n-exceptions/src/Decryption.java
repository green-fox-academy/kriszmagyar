import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Decryption {

  public static void main(String[] args) {

    print(decryptMsg("assets/duplicated-chars.txt", "duplicated"));
    print(decryptMsg("assets/reversed-lines.txt", "reversed"));
    print(decryptMsg("assets/encoded-lines.txt", "shifted"));
    print(reverseOrder("assets/reversed-order.txt"));
  }

  private static List<String> decryptMsg(String path, String method) {

    List<String> msg = getMsg(path);
    List<String> decryptedMsg = new ArrayList<>();

    for (String line : msg) {
      decryptedMsg.add(decryptLine(line, method));
    }

    return decryptedMsg;
  }

  private static List<String> reverseOrder(String path) {
    List<String> msg = getMsg(path);
    List<String> reversedMsg = new ArrayList<>();
    for (int i = msg.size() - 1; i >= 0; i--) {
      reversedMsg.add(msg.get(i));
    }
    return reversedMsg;
  }

  private static List<String> getMsg(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static String decryptLine(String line, String method) {
    switch (method) {
      case "duplicated": return removeDuplication(line);
      case "reversed": return reverse(line);
      case "shifted": return shift(line, -1);
      default: return line;
    }
  }

  private static String removeDuplication(String line) {
    StringBuilder sb = new StringBuilder(line);
    for (int i = 0; i < line.length() / 2; i++) {
      sb.delete(i + 1, i + 2);
    }
    return sb.toString();
  }

  private static String reverse(String line) {
    return new StringBuilder(line).reverse().toString();
  }

  private static String shift(String line, int shift) {
    char[] chars = line.toCharArray();
    char[] shiftedChars = new char[line.length()];

    for (int i = 0; i < line.length(); i++) {
      if (chars[i] == ' ') {
        shiftedChars[i] = chars[i];
        continue;
      }

      int asciiCode = chars[i];
      shiftedChars[i] = (char) (asciiCode + shift);
    }
    return new String(shiftedChars);
  }

  private static void print(List<String> txt) {
    for (String line : txt) {
      System.out.println(line);
    }
  }

}
