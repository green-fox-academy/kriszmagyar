package com.greenfoxacademy.springstart.components;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

  private final AtomicInteger c = new AtomicInteger(0);

  public int get() {
    return c.get();
  }

  public void inc() {
    c.addAndGet(1);
  }

}
