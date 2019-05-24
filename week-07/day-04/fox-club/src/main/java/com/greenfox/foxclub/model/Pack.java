package com.greenfox.foxclub.model;

import java.util.HashSet;
import java.util.Set;

public class Pack {

  private String name;
  private Set<Fox> members;

  public Pack(String name) {
    members = new HashSet<>();
  }

  public void join(Fox fox) {
    members.add(fox);
  }

  public void leave(Fox fox) {
    members.remove(fox);
  }

  public Set<Fox> getMembers() {
    return members;
  }

}