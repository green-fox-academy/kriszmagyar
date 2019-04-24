package basic;

import basic.Person.Gender;

public class Main {

  public static void main(String[] args) {

    Student john = new Student("John", 20, Gender.MALE, "BME");
    Person johnTheClone = john.clone();
    System.out.println(johnTheClone);

  }

}
