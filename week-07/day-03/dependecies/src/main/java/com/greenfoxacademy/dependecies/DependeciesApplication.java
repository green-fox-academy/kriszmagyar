package com.greenfoxacademy.dependecies;

import com.greenfoxacademy.dependecies.service.logger.Logger;
import com.greenfoxacademy.dependecies.service.color.MyColor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependeciesApplication implements CommandLineRunner {

  private final Logger logger;
  private MyColor myColor;

  public DependeciesApplication(Logger logger, MyColor myColor) {
    this.logger = logger;
    this.myColor = myColor;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependeciesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.log("App started!");
    myColor.printColor();
  }
}
