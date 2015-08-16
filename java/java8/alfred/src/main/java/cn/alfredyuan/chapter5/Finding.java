package cn.alfredyuan.chapter5;

import java.util.List;
import java.util.Arrays;

import cn.alfredyuan.chapter4.Dish;
import static cn.alfredyuan.chapter4.Dish.menu;

public class Finding {
  public static void main(String... args) {
    // check to see if a predicate matches at least one element
    if (menu.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("The menu is (somewhat) vegetarian friendly!!");
    }
    
    // check to see if a predicate matches all elements
    if (menu.stream().allMatch(d -> 1000 >= d.getCalories())) {
      System.out.println("The menu is healthy!!!");
    }
    
    // check to see if a predicate matches none element
    if (menu.stream().noneMatch(d -> 1000 < d.getCalories())) {
      System.out.println("The menu is healthy!!!");
    }
    
    // find an element
    menu.stream()
      .filter(Dish::isVegetarian)
      .findAny()
      .ifPresent(System.out::println);
    
    // find the first element
    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    someNumbers.stream()
      .map(x -> x * x)
      .filter(x -> 0 == x % 3)
      .findFirst()
      .ifPresent(System.out::println);
  }
}
