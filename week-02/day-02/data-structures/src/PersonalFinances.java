import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalFinances {

  public static void main(String[] args) {

    List<Integer> costs = new ArrayList<>(Arrays.asList(500, 1000, 1250, 175, 800, 120));
    System.out.println(costs);
    System.out.println(sum(costs)); // expects 3845
    System.out.println(max(costs)); // expects 1250
    System.out.println(min(costs)); // expects 120
    System.out.println(avg(costs)); // expects 640.833...

  }

  private static int sum(List<Integer> list) {
    int result = 0;
    for (int val : list) {
      result += val;
    }
    return result;
  }

  private static int max(List<Integer> list) {
    int max = list.get(0);
    for (int val : list) {
      if (val > max) {
        max = val;
      }
    }
    return max;
  }

  private static int min(List<Integer> list) {
    int min = list.get(0);
    for (int val : list) {
      if (val < min) {
        min = val;
      }
    }
    return min;
  }

  private static double avg(List<Integer> list) {
    return (double) sum(list) / list.size();
  }

}
