package greenfox.org;

class Sponsor {

  private String name;
  private int age;
  private String gender;
  private String company;
  private int hiredStudents;

  Sponsor() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.company = "Google";
    this.hiredStudents = 0;
  }

  Sponsor(String name, int age, String gender, String company) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.company = company;
    this.hiredStudents = 0;
  }

  void hire() {
    this.hiredStudents++;
  }

  void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender
        + " who represents " + this.company + " and hired " + this.hiredStudents
        + " students so far.");
  }

  void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers.");
  }

}
