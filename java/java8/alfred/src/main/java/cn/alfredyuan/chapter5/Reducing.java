package cn.alfredyuan.chapter5;

import java.util.List;
import java.util.Arrays;

public class Reducing {
  public static void main(String... args) {
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

    // summing the elements
    int sum = numbers.stream().reduce(0, Integer::sum);
    System.out.println(sum);
    numbers.stream().reduce(Integer::sum)
        .ifPresent(System.out::println);
    
    // the maximum element
    int max = numbers.stream().reduce(0, Integer::max);
    System.out.println(max);
    
    // the minimum element
    int min = numbers.stream().reduce(0, Integer::min);
    System.out.println(min);
  }
}
