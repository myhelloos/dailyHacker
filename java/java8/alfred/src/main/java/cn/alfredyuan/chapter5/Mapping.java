package cn.alfredyuan.chapter5;

import java.util.List;
import java.util.Arrays;

import cn.alfredyuan.chapter4.Dish;

import static java.util.stream.Collectors.toList;
import static cn.alfredyuan.chapter4.Dish.menu;

public class Mapping {
  public static void main(String... args) {
    // applying a function to each element of a stream
    List<String> dishNames = menu.stream()
        .map(Dish::getName)
        .collect(toList());
    System.out.println(dishNames);
    
    List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
    List<Integer> wordLengths = words.stream()
        .map(String::length)
        .collect(toList());
    System.out.println(wordLengths);
    
    List<Integer> dishNameLengths = menu.stream()
        .map(Dish::getName)
        .map(String::length)
        .collect(toList());
    System.out.println(dishNameLengths);
    
    // Flattening streams
    List<String> uniqueCharacters = words.stream()
        .map(w -> w.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(toList());
    System.out.println(uniqueCharacters);
   
    // mapping number to its square
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<Integer> squares = numbers.stream()
        .map(n -> n*n)
        .collect(toList());
    System.out.println(squares);
    
    // mapping all pairs of numbers
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(4, 5);
    List<int[]> pairs = numbers1.stream()
        .flatMap(i -> 
          numbers2.stream()
            .map(j -> new int[]{i, j})
        ).collect(toList());
    pairs.forEach(intArray -> System.out.println(intArray[0] + " : " + intArray[1]));
    
    // mapping all 3 divisible pairs
    List<int[]> threeDivisiblePairs = numbers1.stream()
        .flatMap(i -> 
          numbers2.stream()
            .filter(j -> 0 == (i+j) % 3)
            .map(j -> new int[]{i, j})
        ).collect(toList());
    threeDivisiblePairs.forEach(intArray -> System.out.println(intArray[0] + " : " + intArray[1]));
  }
}
