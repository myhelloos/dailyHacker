
package cn.alfredyuan.didi;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        boolean[] bools = new boolean[2*n];
        
        int count = 0;
        while(cin.hasNextInt())
        {
            if (count >= bools.length) {
                bools = doubleArray(bools);
            }
            bools[count] = cin.nextBoolean();
            count++;
        }
       
        System.out.println(nOutOfMTrue(n, bools));
    }
    
    public static boolean atLeastTwoTrue(boolean a, boolean b, boolean c) {
        return a ? (b || c) : (b && c);
    }
    
    public static boolean nOutOfMTrue(int n, boolean...booleans) {
        if (n > booleans.length) return false;
        int stillNeed = n;
        for (int i = 0; i < booleans.length && stillNeed >= 0; i++) {
          if (booleans[i]) { stillNeed--; }
        }
        return stillNeed <= 0;
    }
    
    public static boolean[] doubleArray(boolean[] array) {
        boolean[] result = new boolean[array.length * 2];
        for (int i=0; i<array.length; ++i) {
            result[i] = array[i];
        }
        return result;
    }
    
}
