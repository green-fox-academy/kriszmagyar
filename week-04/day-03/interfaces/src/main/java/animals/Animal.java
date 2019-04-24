package main.java.animals;

abstract class Animal {

  private String name;
  private int age;

  Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public abstract String breed();
}
