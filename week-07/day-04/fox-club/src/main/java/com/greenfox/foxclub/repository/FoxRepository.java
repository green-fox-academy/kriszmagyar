package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.model.Fox;
import java.util.List;

public interface FoxRepository {

  List<Fox> get();

  void set(List<Fox> foxes);
}
