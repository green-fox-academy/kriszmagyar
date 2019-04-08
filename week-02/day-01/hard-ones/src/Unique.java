import java.util.Arrays;

public class Unique {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(unique(new int[]{1, 11, 34, 11, 52, 61, 1, 34}))); //  should print: `[1, 11, 34, 52, 61]`
    System.out.println(Arrays.toString(unique(new int[]{1, 2, 2, 2, 3, 1, 4}))); //  should print: `[1, 2, 3, 4]`

  }

  /**
   * Returns a list of numbers where every number in the list occurs only once
   */
  private static int[] unique(int[] arr) {
    int[] results = new int[arr.length];
    int numbOfUniques = 0;

    for (int value : arr) {
      if (!isContains(results, value)) {
        results[numbOfUniques++] = value;
      }
    }

    return Arrays.copyOf(results, numbOfUniques);
  }

  private static boolean isContains(int[] arr, int num) {
    for (int value : arr) {
      if (value == num) {
        return true;
      }
    }
    return false;
  }

}
