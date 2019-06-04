package com.greenfox.guardiansofthegalaxy.service;

import com.greenfox.guardiansofthegalaxy.model.FoodDTO;
import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DraxService {

  private List<FoodDTO> foods = new ArrayList<>();

  public List<FoodDTO> findAll() {
    return foods;
  }

  public FoodDTO findById(long id) throws InvalidArgumentException {
    return foods.stream()
        .filter(f -> f.getId() == id)
        .findFirst()
        .orElseThrow(() -> new InvalidArgumentException(new String[]{"Invalid id!"}));
  }

  public FoodDTO save(String name, int amount, int calories) {
    FoodDTO foodDTO = new FoodDTO(name, amount, calories);
    foods.add(foodDTO);
    return foodDTO;
  }

  public void delete(long id) {
    foods = foods.stream()
        .filter(f -> f.getId() != id)
        .collect(Collectors.toList());
  }

  public boolean contains(long id) {
    return foods.stream()
        .anyMatch(f -> f.getId() == id);
  }
}
