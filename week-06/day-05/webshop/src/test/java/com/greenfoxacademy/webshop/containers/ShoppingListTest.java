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

  @Test
  public void getWithContainsShouldReturnAllItemWhichContainsTheParam() {
    assertTrue(shoppingList
        .getWithContains("nike")
        .stream()
        .allMatch(shopItem -> shopItem.isContains("nike"))
    );
  }

  @Test
  public void getAverageStockShouldReturnTwentyFive() {
    shoppingList.clear();
    shoppingList.add(new ShopItem("Name", "Desc", 100, 0));
    shoppingList.add(new ShopItem("Name", "Desc", 100, 50));
    assertEquals(25.0, shoppingList.getAverageStock(), 0.0);
  }

  @Test
  public void getMostExpensiveItemNameShouldReturnPrinter() {
    shoppingList.clear();
    shoppingList.add(new ShopItem("Name0", "Desc", 1000, 50));
    shoppingList.add(new ShopItem("Name1", "Desc", 500, 50));
    shoppingList.add(new ShopItem("Name2", "Desc", 1400, 50));
    shoppingList.add(new ShopItem("Name3", "Desc", 900, 50));
    assertEquals("Name2", shoppingList.getMostExpensiveItemName());
  }
}