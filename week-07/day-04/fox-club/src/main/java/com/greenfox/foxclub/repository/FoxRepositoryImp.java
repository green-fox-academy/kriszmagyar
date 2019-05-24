package com.greenfox.foxclub.repository;

import com.greenfox.foxclub.model.fox.Fox;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FoxRepositoryImp implements FoxRepository {

  private List<Fox> foxes;

  public FoxRepositoryImp() {
    foxes = new ArrayList<>();
  }

  @Override
  public List<Fox> get() {
    return foxes;
  }

  @Override
  public void set(List<Fox> foxes) {
    this.foxes = foxes;
  }
}
