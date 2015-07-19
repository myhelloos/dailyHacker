package edu.tj.example;

import java.util.function.Predicate;

public class PureFunctios
{
  public static void main(String[] args)
  {
    Predicate<Integer> even = (number) -> {
      System.out.println("Printing here is side effect!");
      return number % 2 == 0;
    };
    
    int i = 50;
    while ((i--) > 0) {
      System.out.println("Is five eveb? - " + even.test(5));
    }
  }
}
