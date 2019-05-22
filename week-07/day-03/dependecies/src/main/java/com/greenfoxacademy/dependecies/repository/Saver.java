package com.greenfoxacademy.dependecies.repository;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.List;

public interface Saver {

  List<Student> get();

  void save(Student item);
}
