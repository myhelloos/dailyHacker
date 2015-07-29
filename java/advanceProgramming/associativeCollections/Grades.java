package associativeCollections;

import java.util.HashMap;

public class Grades {
  public static void main(String[] args) {
    HashMap<String, Integer> grades = new HashMap<>();

    grades.put("Smith", 88);
    grades.put("Brown", 100);
    grades.put("Jones", 77);
    grades.put("Green", 90);

    System.out.println("Simth's grade: " + grades.get("Smith"));
    System.out.println("Size of grades: " + grades.size());

    if (grades.containsKey("Brown")) {
      grades.remove("Brown");
      System.out.println("Brown is successfuly removed.");
    }
    System.out.println("Size of grades: " + grades.size());
  }
}
