package cn.alfredyuan.chapter5;

import cn.alfredyuan.chapter4.Dish;
import static cn.alfredyuan.chapter4.Dish.menu;

import java.util.stream.Stream;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreams {
  public static void main(String... args) {
    // mapping to a numeric stream
    int calories = menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();
    System.out.println(calories);

    // converting back to a stream of objects
    IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
    Stream<Integer> stream = intStream.boxed();
    
    // OptionalInt
    OptionalInt maxCalories = menu.stream()
        .mapToInt(Dish::getCalories)
        .max();
    System.out.println(maxCalories.orElse(-1));
    
    // numeric range
    IntStream evenNumbers = IntStream.rangeClosed(1, 100)
        .filter(n -> 0 == n % 2);
    System.out.println(evenNumbers.count());
    
    // Pythagorean triples
    IntStream.rangeClosed(1, 100).boxed()
      .flatMap(a -> 
        IntStream.rangeClosed(a, 100)
          .mapToObj(b ->
            new double[]{a, b, Math.sqrt(a*a + b*b)}
          ).filter(t -> 0 == t[2] % 1)
      ).limit(10)
      .forEach(t-> System.out.println(t[0] + " " + t[1] + " " + t[2]));
  }
}
