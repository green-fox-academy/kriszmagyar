package basic;

import basic.Person.Gender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    Student john = new Student("John", 20, Gender.MALE, "BME");
    Person johnTheClone = john.clone();

    List<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));

    // the order of your dominoes should look like this: [[1,5], [2,4], [4,6], [5,2], [6,7], [7,1]]
    Collections.sort(dominoes);
    for (Domino d : dominoes) {
      System.out.println(d);
    }

  }

}
