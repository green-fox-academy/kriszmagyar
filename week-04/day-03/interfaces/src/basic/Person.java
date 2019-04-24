package basic;

class Person {

  private String name;
  private int age;
  private Gender gender;

  Person() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = Gender.FEMALE;
  }

  Person(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  void introduce() {
    System.out.println("H1, I'm " + getName() + ", a " + getAge() + " year old " + getGender());
  }

  void getGoal() {
    System.out.println("My goal is: Live for the moment!");
  }

  String getName() {
    return name;
  }

  int getAge() {
    return age;
  }

  Gender getGender() {
    return this.gender;
  }

  enum Gender {MALE, FEMALE}
}
