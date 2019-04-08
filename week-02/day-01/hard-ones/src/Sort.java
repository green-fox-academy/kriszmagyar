import java.util.Arrays;

public class Sort {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(bubble(new int[]{34, 12, 24, 9, 5}, false))); //  should print [5, 9, 12, 24, 34]
    System.out.println(Arrays.toString(bubble(new int[]{34, 12, 24, 9, 5}, true))); //  should print [34, 24, 12, 9, 5]

  }

  private static int[] bubble(int[] arr, boolean desc) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {

        boolean isSwapRequired;
        if (desc) {
          isSwapRequired = arr[j] < arr[j + 1];
        } else {
          isSwapRequired = arr[j] > arr[j + 1];
        }

        if (isSwapRequired) {
          swap(arr, j, j + 1);
        }

      }
    }

    return arr;
  }

  /**
   * Swap two values with a given two indexes in an array
   */
  private static void swap(int[] arr, int index1, int index2) {
    int tmp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tmp;
  }

}
