package greenfox.org;

import greenfox.org.Person.Gender;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Person> people = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Mentor> mentors = new ArrayList<>();
    List<Sponsor> sponsors = new ArrayList<>();

    Person mark = new Person("Mark", 46, Gender.MALE);
    people.add(mark);
    Person jane = new Person();
    people.add(jane);
    Student john = new Student("John Doe", 20, Gender.MALE, "BME");
    students.add(john);
    Student student = new Student();
    students.add(student);
    Mentor gandhi = new Mentor("Gandhi", 148, Gender.MALE, "senior");
    mentors.add(gandhi);
    Mentor mentor = new Mentor();
    mentors.add(mentor);
    Sponsor sponsor = new Sponsor();
    sponsors.add(sponsor);
    Sponsor elon = new Sponsor("Elon Musk", 46, Gender.MALE, "SpaceX");
    sponsors.add(elon);

    student.skipDays(3);

    for (int i = 0; i < 5; i++) {
      elon.hire();
    }

    for (int i = 0; i < 3; i++) {
      sponsor.hire();
    }

    for (Person person : people) {
      person.introduce();
      person.getGoal();
    }

    for (Student person : students) {
      person.introduce();
      person.getGoal();
    }

    for (Mentor person : mentors) {
      person.introduce();
      person.getGoal();
    }

    for (Sponsor person : sponsors) {
      person.introduce();
      person.getGoal();
    }

  }

}
