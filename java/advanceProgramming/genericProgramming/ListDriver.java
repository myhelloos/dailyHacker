package genericProgramming;

public class ListDriver {
public static void main(String[] args) {
        List<String> glist = new List<>(10);
        glist.add("milk");
        glist.add("eggs");
        System.out.println("Grocery list: " + glist.toString());

        List<Integer> nlist = new List<>(5);
        nlist.add(1);
        nlist.add(2);
        nlist.add(3);
        System.out.println("Number list: " + nlist.toString());
}
}
