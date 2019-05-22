package com.greenfoxacademy.dependecies.service.student;

import java.util.List;

public interface Saver<T> {

  List<T> findAll();

  void save(T item);
}
