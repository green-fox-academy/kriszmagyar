package greenfox.org;

class Person {

  private String name;
  private int age;
  private String gender;

  Person() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
  }

  Person(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  void introduce() {
    System.out.println("H1, I'm " + this.name + ", a " + this.age + " year old " + this.gender);
  }

  void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }
}
