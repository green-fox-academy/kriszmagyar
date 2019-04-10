import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matchmaking {

  public static void main(String[] args) {

    List<String> girls = new ArrayList<>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
    List<String> boys = new ArrayList<>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));

    // Write a method that joins the two lists by matching one girl with one boy into a new list
    // If someone has no pair, he/she should be the element of the list too

    System.out.println(makingMatches(girls, boys)); // expects "Eve", "Joe", "Ashley", "Fred"...

  }

  private static List<String> makingMatches(List<String> girls, List<String> boys) {
    List<String> results = new ArrayList<>();
    int size = Math.max(girls.size(), boys.size());

    for (int i = 0; i < size; i++) {

      if (i < girls.size()) {
        results.add(girls.get(i));
      }

      if (i < boys.size()) {
        results.add(boys.get(i));
      }

    }

    return results;
  }

}
