package cn.alfredyuan.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;
import static java.util.Comparator.comparing;;

public class FilteringApples {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    Consumer<Apple> print = t -> System.out.println(t);
    List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
        new Apple(155, "green"), new Apple(120, "red"));

    List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple a) {
        return "red".equals(a.getClass());
      }
    });
    System.out.println("Red apples:");
    foreach(redApples, print);
    List<Apple> weightApples = filterApples(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple a) {
        return 160 < a.getWeight();
      }
    });
    System.out.println("Heavy apples");
    foreach(weightApples, print);
    List<Apple> greenApples = filterApples(inventory,
        (Apple apple) -> "green".equals(apple.getColor()));
    System.out.println("Green apples");
    foreach(greenApples, print);
    inventory.sort(comparing(Apple::getWeight));
    System.out.println("Sorted apple list:");
    foreach(inventory, print);
  }

  public static <T> void foreach(List<T> inventory, Consumer<T> c) {
    for (T t : inventory) {
      c.accept(t);
    }
  }

  public static List<Apple> filterApples(List<Apple> inventory,
      ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }
}
