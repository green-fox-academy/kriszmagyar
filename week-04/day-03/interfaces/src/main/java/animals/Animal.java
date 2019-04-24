package main.java.animals;

abstract class Animal {

  private String name;
  private int age;

  Animal(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

  abstract String breed();
}
