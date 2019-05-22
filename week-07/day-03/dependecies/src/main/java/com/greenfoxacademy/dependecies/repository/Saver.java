package com.greenfoxacademy.dependecies.repository;

import com.greenfoxacademy.dependecies.model.Student;
import java.util.List;

public interface Saver {

  List<Student> findAll();

  void save(Student item);
}
