package com.greenfoxacademy.dependecies.service.student;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements Saver<Student> {

  private List<Student> students;

  public StudentService() {
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
