package collection;

import java.util.PriorityQueue;
import java.io.*;

public class SquareDance {
public static void main(String[] args) {
        PriorityQueue<String> men = new PriorityQueue<>();
        PriorityQueue<String> women = new PriorityQueue<>();

        String line=null;
        String file="collection/Dance.txt";

        String sex = "";

        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
                        while ((line = input.readLine()) != null) {
                                sex = line.substring(0, 1);
                                if ("M".equals(sex)) {
                                        men.add(line.substring(2));
                                } else {
                                        women.add(line.substring(2));
                                }
                        }
                } catch(IOException except) {
                        System.out.println("Error opening file");
                }

        while(!men.isEmpty() && !women.isEmpty()) {
                System.out.println("The dance partners will be: " + men.poll()
                                   + " and " + women.poll());
        }

        if (men.isEmpty()) {
                System.out.println("There are " + women.size() + " women waiting to dance. "
                                   + women.peek() + " is the next woman dancer.");
        }
        if (women.isEmpty()) {
                System.out.println("There are " + men.size() + " men waiting to dance. "
                                   + men.peek() + " is the next man dancer.");
        }
}
}
