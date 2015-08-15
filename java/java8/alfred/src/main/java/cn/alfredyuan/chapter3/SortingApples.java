package cn.alfredyuan.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.alfredyuan.chapter2.Apple;

public class SortingApples {
  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
        new Apple(155, "green"), new Apple(120, "red"), new Apple(80, "red"),
        new Apple(155, "red"), new Apple(120, "green"));

    // step 1 : pass code
    inventory.sort(new AppleComparator());
    System.out.println(inventory);

    // step 2 use an anonymous class
    inventory.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
      }
    });
    System.out.println(inventory);

    // step 3 use lambda expressions
    inventory
        .sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    System.out.println(inventory);
    // use static method comparing in Comparator
    inventory.sort(Comparator.comparing((a) -> a.getWeight()));
    System.out.println(inventory);

    // step 4 use method references
    inventory.sort(Comparator.comparing(Apple::getWeight));
    System.out.println(inventory);

    /**
     * useful methods to compose lambda expressions
     */
    // reversed order
    inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
    System.out.println("reversed: " + inventory);

    // chaining comparators
    inventory.sort(Comparator.comparing(Apple::getWeight).reversed()
        .thenComparing(Apple::getColor));

    Predicate<Apple> redApple = a -> "red".equals(a.getColor());
    // composing predicates
    Predicate<Apple> notRedApple = redApple.negate();
    System.out
        .println("not red apple: " + filterApples(inventory, notRedApple));

    Predicate<Apple> redAndHeavyApple = redApple.and(a -> 150 < a.getWeight());
    System.out.println(
        "red and heavy apple: " + filterApples(inventory, redAndHeavyApple));

    Predicate<Apple> redAndHeavyOrGreenApple = redApple
        .and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
    System.out.println("red and heavy apple or green apple: "
        + filterApples(inventory, redAndHeavyOrGreenApple));

    // composing functions
    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.andThen(g);
    Integer result = h.apply(Integer.valueOf(1));
    System.out.println("The result: " + result);
    Function<Integer, Integer> i = f.compose(g);
    result = i.apply(Integer.valueOf(1));
    System.out.println("The result: " + result);

    // usage of composing functions
    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipline = addHeader
        .andThen(Letter::checkSpelling).andThen(Letter::addFooter);
    Function<String, String> vipTransformationPipline = addHeader
        .andThen(Letter::addFooter);
  }

  public static List<Apple> filterApples(List<Apple> inventory,
      Predicate<Apple> p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }
}
