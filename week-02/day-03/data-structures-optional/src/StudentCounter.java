import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCounter {

  public static void main(String[] args) {

    List<Map<String, Object>> listOfMaps = new ArrayList<>();

    // Given this list of hash maps...

    Map<String, Object> row0 = new HashMap<>();
    row0.put("name", "Theodor");
    row0.put("age", 9.5);
    row0.put("candies", 2);
    listOfMaps.add(row0);

    Map<String, Object> row1 = new HashMap<>();
    row1.put("name", "Paul");
    row1.put("age", 10);
    row1.put("candies", 1);
    listOfMaps.add(row1);

    Map<String, Object> row2 = new HashMap<>();
    row2.put("name", "Mark");
    row2.put("age", 7);
    row2.put("candies", 3);
    listOfMaps.add(row2);

    Map<String, Object> row3 = new HashMap<>();
    row3.put("name", "Peter");
    row3.put("age", 12);
    row3.put("candies", 5);
    listOfMaps.add(row3);

    Map<String, Object> row4 = new HashMap<>();
    row4.put("name", "Olaf");
    row4.put("age", 12);
    row4.put("candies", 7);
    listOfMaps.add(row4);

    Map<String, Object> row5 = new HashMap<>();
    row5.put("name", "George");
    row5.put("age", 3);
    row5.put("candies", 2);
    listOfMaps.add(row5);

    // Display the following things:
    //  - The names of students who have more than 4 candies
    //  - The sum of the age of people who have less than 5 candies

    print(listOfMaps);
    System.out.println(moreThan(listOfMaps, "candies", 4, true)); // expects ["Peter", "Olaf"]

    List<String> names = moreThan(listOfMaps, "candies", 5, false);
    System.out.println(names); // expects ["Theodor", "Paul", "Mark", "George"]
    System.out.println(sumOfAge(listOfMaps, names)); // expects 29.5

  }

  private static List<String> moreThan(List<Map<String, Object>> listOfMaps, String key, int num, boolean isMore) {
    List<String> names = new ArrayList<>();

    for (Map<String, Object> map : listOfMaps) {

      boolean shouldAdd = isMore ? (int) map.get(key) > num : (int) map.get(key) < num;
      if (shouldAdd) {
        names.add((String) map.get("name"));
      }
    }

    return names;
  }

  private static double sumOfAge(List<Map<String, Object>> listOfMaps, List<String> names) {
    double result = 0.0;

    for (Map<String, Object> map : listOfMaps) {
      String name = (String) map.get("name");
      if (names.contains(name)) {

        if (map.get("age") instanceof Integer) {
          result += (double) ((int) map.get("age"));
        } else {
          result += (double) map.get("age");
        }
      }
    }

    return result;
  }

  private static void print(List<Map<String, Object>> listOfMaps) {
    for (Map<String, Object> map : listOfMaps) {
      System.out.println(map);
    }
  }

}
