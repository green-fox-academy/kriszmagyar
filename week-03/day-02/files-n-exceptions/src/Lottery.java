import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottery {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lottery numbers in lottery.csv
    List<String> data = getData("assets/lottery.csv");
    System.out.println(mostCommon(data, 5));
  }

  private static List<Integer> mostCommon(List<String> data, int n) {

    List<int[]> winningNumbers = getWinningNumbers(data);
    Map<Integer, Integer> numberCount = new HashMap<>();

    for (int i = 1; i <= 90; i++) {
      numberCount.put(i, 0);
    }

    for (int[] numbers : winningNumbers) {
      for (int num : numbers) {
        int prevCount = numberCount.get(num);
        numberCount.put(num, ++prevCount);
      }
    }
    return getMaxes(numberCount, n);
  }

  private static List<String> getData(String path) {
    try {
      return Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
  }

  private static List<int[]> getWinningNumbers(List<String> data) {
    List<int[]> results = new ArrayList<>();
    int numberOfWinners = 5;

    for (String line : data) {
      String[] lineData = line.split(";");
      String[] numbers = Arrays.copyOfRange(lineData, lineData.length - numberOfWinners, lineData.length);
      results.add(toIntArr(numbers));
    }
    return results;
  }

  private static List<Integer> getMaxes(Map<Integer, Integer> map, int n) {
    List<Integer> valuesInOrder = new ArrayList<>(map.values());
    valuesInOrder.sort(Comparator.reverseOrder());
    List<Integer> results = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue().equals(valuesInOrder.get(i)) && results.size() < n) {
          results.add(entry.getKey());
        }
      }
    }

    return results;
  }

  private static int[] toIntArr(String[] arr) {
    int[] intArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      intArr[i] = Integer.parseInt(arr[i]);
    }
    return intArr;
  }

  private static void print(List<int[]> winningNumbers) {
    for (int[] arr : winningNumbers) {
      System.out.println(Arrays.toString(arr));
    }
  }

  private static void print(Map<Integer, Integer> map) {
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

}
