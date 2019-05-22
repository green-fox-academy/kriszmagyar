package com.greenfoxacademy.dependecies.service.student;

import com.greenfoxacademy.dependecies.model.Student;
import com.greenfoxacademy.dependecies.repository.Saver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private Saver saver;

  public List<Student> findAll() {
    return saver.findAll();
  }

  public void save(Student student) {
    saver.save(student);
  }
}
