package edu.tj.example;

import java.util.function.Function;

public class HigherOrderFunction
{
  public static Function<String, String> greet(String greeting) {
    return (String name) -> greeting + " " + name + "!";
  }
  public static <T, R> int highSum(Function<T, Integer> f1,
      Function<R, Integer> f2, T data1, R data2)
  {
    return f1.apply(data1) + f2.apply(data2);
  }

  public static void main(String[] args)
  {
    Function<String, Integer> strToInt = s -> Integer.parseInt(s);

    highSum(strToInt, strToInt, "5", "4");
    
    System.out.println(greet("hello").apply("cruel world"));
    
    Function<String, String> howdy = greet("Howdy");
    
    System.out.println(howdy.apply("Tanya"));
    
  }
}
