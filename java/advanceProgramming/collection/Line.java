package collection;

import java.util.PriorityQueue;

public class Line{
  public static void main(String[] args) {
    PriorityQueue<String> line = new PriorityQueue<>();

    line.add("Davide");
    line.add("Cynthia");
    line.add("Raymond");
    line.add("Bryan");
    line.add("Clayton");

    System.out.println("The line: ");
    for (String name : line) {
      System.out.println(name);
    }

    line.remove("Raymond");

    System.out.println("\nThe line");
    for (String name : line) {
      System.out.println(name);
    }

    System.out.println("The head: " + line.peek());
  }
}
