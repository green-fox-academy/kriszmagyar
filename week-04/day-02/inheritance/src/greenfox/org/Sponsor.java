package greenfox.org;

class Sponsor extends Person {

  private String company;
  private int hiredStudents;

  Sponsor() {
    super();
    this.company = "Google";
    this.hiredStudents = 0;
  }

  Sponsor(String name, int age, Gender gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  void hire() {
    this.hiredStudents++;
  }

  @Override
  void introduce() {
    System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old " + getGender()
        + " who represents " + this.company + " and hired " + this.hiredStudents
        + " students so far.");
  }

  @Override
  void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers.");
  }

}
