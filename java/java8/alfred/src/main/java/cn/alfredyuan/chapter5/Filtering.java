package cn.alfredyuan.chapter5;

import java.util.List;
import java.util.Arrays;

import cn.alfredyuan.chapter4.Dish;

import static java.util.stream.Collectors.toList;
import static cn.alfredyuan.chapter4.Dish.menu;

public class Filtering {
  public static void main(String... args) {
    // filtering with a predicate
    List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian)
        .collect(toList());
    System.out.println(vegetarianMenu);

    // filtering unique elements
    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream().filter(i -> 0 == i % 2).distinct()
        .forEach(System.out::print);

    // Truncating a stream
    List<Dish> dishes = menu.stream().filter(d -> 300 <= d.getCalories())
        .limit(3).collect(toList());
    System.out.println(dishes);

    // Skipping elements
    List<Dish> skip2Dish = menu.stream().filter(d -> 300 <= d.getCalories())
        .skip(2).collect(toList());
    System.out.println(skip2Dish);
  }
}
