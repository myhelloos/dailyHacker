import java.util.Scanner;


public class q3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr1 = new int[num];
        int[] arr2 = new int[num];

        int res = 0;
        
        for (int i =0; i<num; i++) {
            arr1[i] = in.nextInt();
            arr2[i] = in.nextInt();
        }

        for (int i = 1; i<num; i++) {
            int val1 = Math.abs(arr1[i] - arr1[i-1]);
            int val2 = Math.abs(arr2[i] - arr2[i-1]);
            res += val1 > val2 ? val2 : val1;
        }

        System.out.println(res);
    }
}
