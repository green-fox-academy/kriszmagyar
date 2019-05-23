package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.repository.FoxRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {

  private FoxRepository fr;
  private List<Fox> foxes;

  public FoxService(FoxRepository fr) {
    this.fr = fr;
    foxes = fr.get();
  }

  public Fox getByName(String name) {
    return foxes.stream()
        .filter(f -> f.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  public boolean exists(String name) {
    return foxes.stream()
        .map(Fox::getName)
        .anyMatch(n -> n.equals(name));
  }

  public void add (Fox fox) {
    foxes.add(fox);
    fr.set(foxes);
  }

}
