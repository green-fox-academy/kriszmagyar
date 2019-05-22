package com.greenfoxacademy.dependecies.service.student;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.List;

public interface Saver {

  List<Student> findAll();

  void save(Student item);
}
