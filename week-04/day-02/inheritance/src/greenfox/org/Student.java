package greenfox.org;

class Student {
  private String name;
  private int age;
  private String gender;
  private String previousOrganization;
  private int skippedDays;

  Student() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  Student(String name, int age, String gender, String previousOrganization) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  void skipDays(int n) {

  }

  void introduce() {

  }

  void getGoal() {

  }

}
