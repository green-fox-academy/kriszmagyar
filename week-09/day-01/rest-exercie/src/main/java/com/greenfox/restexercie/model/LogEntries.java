package com.greenfox.restexercie.model;

import java.util.List;

public class LogEntries {

  private List<Log> entries;
  private int entry_count;

  public LogEntries(List<Log> entries) {
    this.entries = entries;
    entry_count = entries.size();
  }

  public List<Log> getEntries() {
    return entries;
  }

  public int getEntry_count() {
    return entry_count;
  }
}
