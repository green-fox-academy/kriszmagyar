package com.greenfoxacademy.dependecies.service.color;

import org.springframework.stereotype.Service;

@Service
public class BlueColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("Blue");
  }
}
