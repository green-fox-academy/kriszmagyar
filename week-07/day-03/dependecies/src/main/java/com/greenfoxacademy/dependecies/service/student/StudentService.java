package com.greenfoxacademy.dependecies.service.student;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements Saver<Student> {

  @Override
  public List<Student> findAll() {
    return null;
  }

  @Override
  public void save(Student item) {

  }
}
