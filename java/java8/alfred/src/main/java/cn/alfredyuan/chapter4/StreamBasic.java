package cn.alfredyuan.chapter4;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import static cn.alfredyuan.chapter4.Dish.menu;

public class StreamBasic {
  public static void main(String[] args) {
    // Java 7
    getLowCaloricDishesNamesInJava7(menu).forEach(System.out::println);

    System.out.println("---");

    // Java 8
    getLowCaloricDishesNamesInJava8(menu).forEach(System.out::println);

    System.out.println("---");

    // Java 8 parallel
    paralelGetLowCaloricDishesNamesInJava8(menu).forEach(System.out::println);

    List<String> topThreeCaloricDishNames = menu.stream()
        .sorted(comparing(Dish::getCalories)).limit(3).map(Dish::getName)
        .collect(toList());
    System.out.println(topThreeCaloricDishNames);

    List<String> names = menu.stream().filter(d -> {
      System.out.println("filtering" + d.getName());
      return 300 <= d.getCalories();
    }).map(d -> {
      System.out.println("mapping" + d.getName());
      return d.getName();
    }).limit(3).collect(toList());
    System.out.println(names);

    // Map<Dish.Type, List<Dish>> dishesByType =
    // menu.stream().collect(groupingBy(Dish::getType));
  }

  public static List<String> getLowCaloricDishesNamesInJava7(
      List<Dish> dishes) {
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish d : dishes) {
      if (400 >= d.getCalories()) {
        lowCaloricDishes.add(d);
      }
    }
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
      @Override
      public int compare(Dish d1, Dish d2) {
        return Integer.compare(d1.getCalories(), d2.getCalories());
      }
    });
    List<String> lowCaloricDishesName = new ArrayList<>();
    for (Dish d : lowCaloricDishes) {
      lowCaloricDishesName.add(d.getName());
    }
    return lowCaloricDishesName;
  }

  public static List<String> getLowCaloricDishesNamesInJava8(
      List<Dish> dishes) {
    return dishes.stream().filter(d -> 400 >= d.getCalories())
        .sorted(comparing(Dish::getCalories)).map(Dish::getName)
        .collect(toList());
  }

  public static List<String> paralelGetLowCaloricDishesNamesInJava8(
      List<Dish> dishes) {
    return dishes.parallelStream().filter(d -> 400 >= d.getCalories())
        .sorted(comparing(Dish::getCalories)).map(Dish::getName)
        .collect(toList());
  }
}
