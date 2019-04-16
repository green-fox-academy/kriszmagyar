import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Core {

  enum Request {
    GET, POST
  }

  public static void main(String[] args) {

    System.out.println(copyFiles("assets/copyFrom.txt", "assets/copyTo.txt")); // excepts to copy successfully

    List<String> logs = getLogs("assets/log.txt");
    System.out.println(Arrays.toString(getUniqueIpAddresses(logs)));

    System.out.println(getRequestRatio(logs));
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

  private static List<String> getLogs(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static String[] getUniqueIpAddresses(List<String> logs) {
    Set<String> ips = new HashSet<>();
    for (String line : logs) {
      ips.add(getIp(line));
    }
    return ips.toArray(new String[0]);
  }

  private static String getIp(String line) {
    return line.split(" ")[8];
  }

  private static double getRequestRatio(List<String> logs) {
    int sumOfGet = 0;
    int sumOfPost = 0;

    for (String line : logs) {
      String req = getReqType(line);

      if (req.equals(Request.GET.name())) {
        sumOfGet++;
      }

      if (req.equals(Request.POST.name())) {
        sumOfPost++;
      }
    }
    return (double) sumOfGet / sumOfPost;
  }

  private static String getReqType(String line) {
    return line.split(" ")[11];
  }

}
