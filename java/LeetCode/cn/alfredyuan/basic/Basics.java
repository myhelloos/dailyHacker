package cn.alfredyuan.basic;

public class Basics {
  public static void main(String... args) {
    int value = Integer.MAX_VALUE;
    long biggerValue = value + 1;
    System.out.println(biggerValue);
    long veryLargeNumber = Long.MAX_VALUE;
    int fromLargeNumber = (int) veryLargeNumber;
    System.out.println(fromLargeNumber);
  } 
}
