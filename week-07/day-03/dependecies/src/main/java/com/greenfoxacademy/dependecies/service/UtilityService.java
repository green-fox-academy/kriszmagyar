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

  public String encode(String text, int number) {
    if (number < 0) {
      number = 26 + number;
    }

    String result = "";
    for(int i = 0; i < text.length(); i++) {
      int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
      result += (char)(((int)text.charAt(i) + number - offset) % 26 + offset);
    }
    return result;
  }

  public String decode(String text, int number) {
    return encode(text, -number);
  }

}
