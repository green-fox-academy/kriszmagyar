package com.greenfoxacademy.dependecies.service.color;

import com.greenfoxacademy.dependecies.service.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RedColor implements MyColor {

  @Autowired
  private Logger logger;

  @Override
  public void printColor() {
    logger.log("Red");
  }
}
