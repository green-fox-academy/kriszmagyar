package com.greenfoxacademy.webshop.components;

public class SearchCriteria {

  private String search = "";
  private String orderBy = "";
  private boolean desc = false;

  public SearchCriteria() {
  }

  public SearchCriteria(String search) {
    this.search = search;
  }

  public SearchCriteria(String search, String orderBy, boolean desc) {
    this.search = search;
    this.orderBy = orderBy;
    this.desc = desc;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public boolean isDesc() {
    return desc;
  }

  public void setDesc(boolean desc) {
    this.desc = desc;
  }
}
