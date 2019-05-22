package com.greenfoxacademy.dependecies.service;

import com.greenfoxacademy.dependecies.model.Email;
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

  public Email validateEmail(String email) {
    String color = email.contains("@") && email.contains(".") ? "green" : "red";
    return new Email(email, color);
  }

}
