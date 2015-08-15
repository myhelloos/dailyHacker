package cn.alfredyuan.chapter3;

import java.util.function.Supplier;

import cn.alfredyuan.chapter2.Apple;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstructorReferencesTest {
  public static void main(String[] args) {
    Supplier<Apple> c1 = Apple::new;
    System.out.println(c1.get());

    Function<Integer, Apple> c2 = Apple::new;
    System.out.println(c2.apply(10));

    List<Integer> weights = Arrays.asList(7, 3, 4, 5, 10);
    List<Apple> apples = map(weights, c2);
    System.out.println(apples);

    Function<String, Apple> c3 = Apple::new;
    System.out.println(c3.apply("red"));

    List<String> colors = Arrays.asList("red", "green", "orange", "lightred");
    apples = map(colors, c3);
    System.out.println(apples);

    BiFunction<Integer, String, Apple> c4 = Apple::new;
    System.out.println(c4.apply(Integer.valueOf(10), "red"));
  }

  public static <T, R> List<T> map(List<R> list, Function<R, T> f) {
    List<T> result = new ArrayList<>();
    for (R e : list) {
      result.add(f.apply(e));
    }
    return result;
  }
}
