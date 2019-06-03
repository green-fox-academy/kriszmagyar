package com.greenfox.restexercie.model;

public class LogQuery {

  private int count;
  private int page;
  private String q;

  public LogQuery() {
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public String getQ() {
    return q;
  }

  public void setQ(String q) {
    this.q = q;
  }
}
