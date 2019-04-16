import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottery {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lottery numbers in lottery.csv
    List<String> data = getData("assets/lottery.csv");
    System.out.println(mostCommon(data, 5));
  }

  private static List<String> getData(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static List<Integer> mostCommon(List<String> data, int n) {

    List<int[]> winningNumbers = getWinningNumbers(data);

    print(winningNumbers);

    return new ArrayList<>();
  }

  private static List<int[]> getWinningNumbers(List<String> data) {
    List<int[]> results = new ArrayList<>();
    for (String line : data) {
      String[] lineData = line.split(";");
      String[] numbers = Arrays.copyOfRange(lineData, lineData.length - 5, lineData.length);
      int[] wNumbers = new int[5];
      for (int i = 0; i < numbers.length; i++) {
        wNumbers[i] = Integer.parseInt(numbers[i]);
      }
      results.add(wNumbers);
    }
    return results;
  }

  private static void print(List<int[]> winningNumbers) {
    for (int[] arr : winningNumbers) {
      System.out.println(Arrays.toString(arr));
    }
  }

}
