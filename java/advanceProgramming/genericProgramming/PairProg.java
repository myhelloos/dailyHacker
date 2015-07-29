package genericProgramming;

public class PairProg {
   public static void main(String[] args) {
      PairClass<String, Integer> grade1 = new PairClass<String, Integer>
         ("Williams", 90);
      PairClass<String, Integer> grade2 = new PairClass<String, Integer>
         ("Brown", 44);
      System.out.println(grade1.first());
      System.out.println(grade1.second());
      System.out.println(grade2.first());
      System.out.println(grade2.second());
   }
}
