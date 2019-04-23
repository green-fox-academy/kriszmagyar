package greenfox.org;

class Mentor extends Person {

  private String level;

  Mentor() {
    super();
    this.level = "intermediate";
  }

  Mentor(String name, int age, Gender gender, String level) {
    super(name, age, gender);
    this.level = level;
  }

  @Override
  void introduce() {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender()
        + " " + this.level + " mentor.");
  }

  @Override
  void getGoal() {
    System.out.println("My goal is: Educate brilliant junior software developers.");
  }

}
