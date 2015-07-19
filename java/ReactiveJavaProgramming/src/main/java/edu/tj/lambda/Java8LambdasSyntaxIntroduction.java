package edu.tj.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.tj.common.Program;

public class Java8LambdasSyntaxIntroduction implements Program
{
  interface Mapper<V, M>
  {
    M map(V value);
  }

  public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper)
  {
    List<M> mapped = new ArrayList<>(list.size());
    for (V v : list) {
      mapped.add(mapper.map(v));
    }
    return mapped;
  }

  interface Action<V>
  {
    void act(V value);
  }

  public static <V> void act(List<V> list, Action<V> action)
  {
    for (V v : list) {
      action.act(v);
    }
  }

  @Override
  public String name()
  {
    return "Introduction to the Java 8 new syntax and semantics";
  }

  @Override
  public int chapter()
  {
    return 2;
  }

  @Override
  public void run()
  {
    // A list of numbers;
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> mapped = map(numbers, new Mapper<Integer, Integer>()
    {
      @Override
      public Integer map(Integer value)
      {
        return value * value;
      }
    });

    List<Integer> lambdaMapped = map(numbers, value -> value * value);

    Mapper<Integer, Integer> square = value -> {
      System.out.println("Calculating the square of " + value);
      return value * value;
    };

    act(numbers, value -> System.out.println(value));
    act(mapped, System.out::println);

  }

  public static void main(String[] args)
  {
    new Java8LambdasSyntaxIntroduction().run();
  }
}
