package greenfox.org;

class Mentor {

  private String name;
  private int age;
  private String gender;
  private String level;

  Mentor() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.level = "intermediate";
  }

  Mentor(String name, int age, String gender, String level) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.level = level;
  }

  void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender
        + " " + this.level + " mentor.");
  }

  void getGoal() {
    System.out.println("My goal is: Educate brilliant junior software developers.");
  }

}
