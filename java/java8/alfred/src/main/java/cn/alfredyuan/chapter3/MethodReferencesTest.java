package cn.alfredyuan.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferencesTest {
  public static void main(String[] args) {
    List<String> str = Arrays.asList("a", "b", "A", "B");
    Comparator<String> comparator = String::compareToIgnoreCase;
    str.sort(comparator);
    System.out.println("Sorted: " + str.toString());
    str.sort(comparator.reversed());
    System.out.println("Reversed: " + str.toString());
  }
}
