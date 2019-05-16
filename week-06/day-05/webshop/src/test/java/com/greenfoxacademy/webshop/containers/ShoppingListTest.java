package com.greenfoxacademy.webshop.containers;

import static org.junit.Assert.*;

import com.greenfoxacademy.webshop.components.ShopItem;
import java.util.List;
import org.junit.Test;

public class ShoppingListTest {

  private ShoppingList shoppingList = new ShoppingList();

  @Test
  public void getAvailableShouldReturnShopItemsWhereQuantityGreaterThanZero() {
    assertTrue(shoppingList
        .getAvailable()
        .stream()
        .allMatch(ShopItem::isAvaiable)
    );
  }
}