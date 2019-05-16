package com.greenfoxacademy.webshop.components;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShopItemTest {

  // Default values
  private static final String NAME = "Name";
  private static final String DESC = "Description";
  private static final double PRICE = 100.0;
  private static final int QUANTITY = 50;

  @Test
  public void isAvailableReturnsTrueIfQuantityGreaterThanZero() {
    assertTrue(new ShopItem(NAME, DESC, PRICE, 100).isAvaiable());
  }

  @Test
  public void isAvailableReturnsFalseIfQuantityIsZero() {
    assertFalse(new ShopItem(NAME, DESC, PRICE, 0).isAvaiable());
  }
}