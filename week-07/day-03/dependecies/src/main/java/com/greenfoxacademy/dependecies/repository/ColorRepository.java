package com.greenfoxacademy.dependecies.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ColorRepository {

  private List<String> colors;

  public ColorRepository() {
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("lime");
    colors.add("orange");
    colors.add("magenta");
  }

  public String getWithIndex(int index) {
    return colors.get(index);
  }

  public int size() {
    return colors.size();
  }
}
