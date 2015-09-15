package cn.alfredyuan.chapter6;

import cn.alfredyuan.chapter4.Dish;
import static java.util.stream.Collectors.reducing;
import static cn.alfredyuan.chapter4.Dish.menu;

public class Reducing {
  public static void main(String... args) {
    int totalCalories = menu.stream()
        .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
    System.out.println("Total calories in menu: " + totalCalories);
    
    totalCalories = menu.stream()
        .collect(reducing(0, Dish::getCalories, Integer::sum));
    System.out.println("Total calories in menu: " + totalCalories);
    
    totalCalories = menu.stream()
        .map(Dish::getCalories)
        .reduce(Integer::sum)
        .orElse(-1);
    System.out.println("Total calories in menu: " + totalCalories);
    
    totalCalories = menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();
    System.out.println("Total calories in menu: " + totalCalories);
  }
}
