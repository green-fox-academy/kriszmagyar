package com.greenfoxacademy.webshop.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShopItemTest {

  // Default values
  private static final String NAME = "Name";
  private static final String DESC = "Description";
  private static final double PRICE = 100.0;
  private static final int STOCK = 50;

  @Test
  public void isAvailableReturnsTrueIfStockGreaterThanZero() {
    assertTrue(new ShopItem(NAME, DESC, PRICE, 100).isAvaiable());
  }

  @Test
  public void isAvailableReturnsFalseIfStockIsZero() {
    assertFalse(new ShopItem(NAME, DESC, PRICE, 0).isAvaiable());
  }

  @Test
  public void isContainsShouldReturnsTrueIfGivenStringIsInName() {
    assertTrue(new ShopItem("Nike shoes", DESC, PRICE, STOCK)
        .isContains("nike"));
  }

  @Test
  public void isContainsShouldReturnsTrueIfGivenStringIsInDescription() {
    assertTrue(new ShopItem(NAME, "This is some nice nike shoes!", PRICE, STOCK)
        .isContains("nike"));
  }

  @Test
  public void isContainsShouldReturnsFalseIfGivenStringIsNotInNameNorDescription() {
    assertFalse(new ShopItem("Nike shoes", "Some nice nike shoes!", PRICE, STOCK)
        .isContains("adidas"));
  }
}