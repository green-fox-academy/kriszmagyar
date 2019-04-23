package greenfox.org;

class Student extends Person {

  private String previousOrganization;
  private int skippedDays;

  Student() {
    super();
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  Student(String name, int age, Gender gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  void skipDays(int n) {
    this.skippedDays += n;
  }

  @Override
  void introduce() {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender()
        + " from " + this.previousOrganization + " who skipped " + this.skippedDays
        + " days from the course already.");
  }

  @Override
  void getGoal() {
    System.out.println("My goal is: Be a junior software developer.");
  }

}
