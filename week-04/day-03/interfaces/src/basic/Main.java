package basic;

import basic.Person.Gender;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Student john = new Student("John", 20, Gender.MALE, "BME");
    Student johnTheClone = john.clone();

    // the order of your dominoes should look like this:
    // [[1,5], [2,4], [4,6], [5,2], [6,7], [7,1]]
    List<Domino> dominoes = initDominoes();
    Collections.sort(dominoes);
    print(dominoes);

    // It should compare the completed field first
    // Then the description
    List<Thing> things = initThings();
    Collections.sort(things);
    print(things);

  }

  private static List<Domino> initDominoes() {
    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));
    return dominoes;
  }

  private static List<Thing> initThings() {
    List<Thing> things = new ArrayList<>();
    things.add(new Thing("Walk the dog"));
    things.add(new Thing("Do homework"));
    things.add(new Thing("Do this task"));
    things.add(new Thing("Walk the dog again"));
    return things;
  }

  private static <T> void print(List<T> list) {
    for (T item : list) {
      System.out.println(item);
    }
  }

}
