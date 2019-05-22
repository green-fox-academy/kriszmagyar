package com.greenfoxacademy.dependecies.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class Printer {

  public void log(String msg) {
    System.out.println(LocalDateTime.now() + " - my printer says: " + msg);
  }

}
