import java.util.Arrays;

public class Unique {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(unique(new int[]{1, 11, 34, 11, 52, 61, 1, 34}))); //  should print: `[1, 11, 34, 52, 61]`
    System.out.println(Arrays.toString(unique(new int[]{1, 2, 2, 2, 3, 1, 4}))); //  should print: `[1, 2, 3, 4]`

  }

  /**
   * Returns a list of numbers where every number in the list occurs only once
   */
  public static int[] unique(int[] arr) {
    int[] tmpResults = new int[arr.length];
    int numbOfUniques = 0;

    for (int value : arr) {
      if (!isContains(tmpResults, value)) {
        tmpResults[numbOfUniques++] = value;
      }
    }

    int[] results = new int[numbOfUniques];
    System.arraycopy(tmpResults, 0, results, 0, numbOfUniques);

    return results;
  }

  public static boolean isContains(int[] arr, int num) {
    for (int value : arr) {
      if (value == num) {
        return true;
      }
    }
    return false;
  }

}
