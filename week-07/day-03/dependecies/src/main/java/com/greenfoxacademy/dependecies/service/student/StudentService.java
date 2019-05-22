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
    return saver.get();
  }

  public void save(Student student) {
    if (student == null || student.getName().isEmpty()) {
      return;
    }
    saver.save(student);
  }

  public int count() {
    return saver.get().size();
  }

  public boolean isExist(String name) {
    return saver.get().stream()
        .map(s -> s.getName().toLowerCase())
        .anyMatch(s -> s.equals(name.toLowerCase()));
  }
}
