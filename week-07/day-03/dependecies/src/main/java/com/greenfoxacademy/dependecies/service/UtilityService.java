package com.greenfoxacademy.dependecies.service;

import com.greenfoxacademy.dependecies.repository.ColorRepository;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class UtilityService {

  private ColorRepository colorRepository;

  public UtilityService(ColorRepository colorRepository) {
    this.colorRepository = colorRepository;
  }

  public String randomColor() {
    return colorRepository.getWithIndex(
        new Random().nextInt(colorRepository.size())
    );
  }

}
