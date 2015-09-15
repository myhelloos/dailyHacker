
public class TestClass {
  static {
    int x = 5;
  }
  static int x, y;

   private static void testMethod(){

        System.out.println("testMethod");

   }
   
   public int getUniqueNumber(int inputs[]) {
     int result = 0;
     for (int input : inputs) {
       result = result ^ input;
     }
     return result;
   }

   public static void main(String[] args) {
//     x--;
//     myMethod();
//     System.out.println(x+y+
//         ++x);
     int i=0;
     Integer j = new Integer(0);
     System.out.println(i==j);
     System.out.println(j.equals(i));
   }
   
   public static void myMethod() {
     y = x++ + ++x;
   }

}

class Customer {
  private String name;
  public Customer(String name) {
    this.name = name;
  }
  
  public void buy(int cost){
    new Thread(new UniversalInsurance(this, cost)).start();
  }
}

class UniversalInsurance implements Runnable{
  private final static int TOTAL = 2000000;
  static int remains = TOTAL;
  static java.util.Hashtable<Customer, Integer> customerTable = new java.util.Hashtable<>();
  
  private Customer customer;
  private Integer cost;
  public UniversalInsurance(Customer customer, int cost) {
   this.customer = customer;
   this.cost = cost;
  }
  
  @Override
  public void run() {
    if (sell(customer, cost)) {
      int prevCost = customerTable.getOrDefault(customer, 0);
      customerTable.put(customer, prevCost+cost);
    };
  }
  
  public synchronized boolean sell(Customer customer, int cost) {
    if (remains >= cost) {
      remains -= cost;
      return true;
    } else {
      return false;
    }
  }
}
