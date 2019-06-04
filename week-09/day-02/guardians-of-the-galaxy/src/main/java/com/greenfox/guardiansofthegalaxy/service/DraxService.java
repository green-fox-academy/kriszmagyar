package com.greenfox.guardiansofthegalaxy.service;

import com.greenfox.guardiansofthegalaxy.model.FoodDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DraxService {

  private List<FoodDTO> foods = new ArrayList<>();

  public List<FoodDTO> findAll() {
    return foods;
  }
}
