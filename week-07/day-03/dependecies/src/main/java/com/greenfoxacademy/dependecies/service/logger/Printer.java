package com.greenfoxacademy.dependecies.service.logger;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class Printer implements Logger {

  @Override
  public void log(String msg) {
    System.out.println(LocalDateTime.now() + " - my printer says: " + msg);
  }

}
