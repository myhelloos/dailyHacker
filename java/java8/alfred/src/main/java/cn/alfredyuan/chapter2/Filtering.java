package cn.alfredyuan.chapter2;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Filtering {
  public static void main(String... args) {
    List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
        new Apple(155, "green"), new Apple(120, "red"));
    List<Apple> redApples = filter(inventory,
        (Apple apple) -> "red".equals(apple.getColor()));
    for (Apple apple : redApples) {
      System.out.println(apple.toString());
    }
    Thread t = new Thread(() -> System.out.println("Hello world"));
    t.start();
  }

  public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
    List<T> result = new ArrayList<>();

    for (T t : inventory) {
      if (p.test(t)) {
        result.add(t);
      }
    }

    return result;
  }
}
