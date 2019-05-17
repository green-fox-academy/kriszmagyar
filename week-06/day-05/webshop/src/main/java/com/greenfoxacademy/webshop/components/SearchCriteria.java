package com.greenfoxacademy.webshop.components;

public class SearchCriteria {

  private String search = "";
  private boolean isAvailable = false;
  private String orderBy = "";
  private boolean desc = false;

  public SearchCriteria() {
  }

  public SearchCriteria(String search) {
    this.search = search;
  }

  public SearchCriteria(String search, boolean isAvailable) {
    this.search = search;
    this.isAvailable = isAvailable;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(boolean available) {
    isAvailable = available;
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

  @Override
  public String toString() {
    return "SearchCriteria{" +
        "search='" + search + '\'' +
        ", isAvailable=" + isAvailable +
        ", orderBy='" + orderBy + '\'' +
        ", desc=" + desc +
        '}';
  }
}
