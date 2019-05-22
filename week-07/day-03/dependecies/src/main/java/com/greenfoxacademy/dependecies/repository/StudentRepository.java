package com.greenfoxacademy.dependecies.repository;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements Saver {

  private List<Student> students;

  public StudentRepository() {
    students = new ArrayList<>();
    students.add(new Student("Sanyi"));
    students.add(new Student("Lilla"));
    students.add(new Student("John"));
  }

  @Override
  public List<Student> findAll() {
    return students;
  }

  @Override
  public void save(Student student) {
    students.add(student);
  }
}
