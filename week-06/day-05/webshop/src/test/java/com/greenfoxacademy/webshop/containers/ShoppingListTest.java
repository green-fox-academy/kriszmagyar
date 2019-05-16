package com.greenfoxacademy.webshop.containers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.greenfoxacademy.webshop.components.ShopItem;
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

  @Test
  public void getCheapestFirstShouldReturnTheOneWithTheLowerPriceFirst() {
    double min = shoppingList
        .getCheapestFirst()
        .stream()
        .map(ShopItem::getPrice)
        .min((p1, p2) -> (int) (p1 - p2))
        .orElse(0.0);
    assertEquals(shoppingList.getCheapestFirst().get(0).getPrice(), min, 0.0);
  }
}