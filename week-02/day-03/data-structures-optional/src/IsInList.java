import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsInList {

  public static void main(String[] args) {
    // Check if list contains all of the following elements: 4,8,12,16
    // Create a method that accepts list as an input
    // it should return "true" if it contains all, otherwise "false"

    List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));

    System.out.println(checkNums(list, Arrays.asList(4, 8, 12, 16, 16))); // expects true
    System.out.println(checkNums(list, Arrays.asList(4, 8, 12, 16, 18))); // expects false
    System.out.println(checkNums(list, Arrays.asList(4, 8))); // expects true
  }

  private static boolean checkNums(List<Integer> list, List<Integer> subList) {
    for (int num : subList) {
      if (!list.contains(num)) {
        return false;
      }
    }
    return true;
  }

}
