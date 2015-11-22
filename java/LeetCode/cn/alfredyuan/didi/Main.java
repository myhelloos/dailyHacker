
package cn.alfredyuan.didi;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);        

        while(cin.hasNextLine())
        {
            System.out.println(getLongest(cin.nextLine()));
        }
       
    }
    
    public static String getLongest(String line) {
        int begin=0, end=0, length=0, templength = 0, sum=0, tempSum=0;
        for (int i=0; i < line.length(); ++i) {
            if (isNum(line.charAt(i))) {
                templength++;
                tempSum = tempSum * 10 + line.charAt(i);
            } else {
                if (templength > length || (templength == length && tempSum > sum)) {
                    length = templength;
                    sum = tempSum;
                    end = i;
                    begin = end - length;
                }
                templength = 0;
                tempSum =0;
            }
        }
        if (templength > length || (templength == length && tempSum > sum)) {
            length = templength;
            sum = tempSum;
            end = line.length();
            begin = end - length;
        }
        return line.substring(begin, end);
    }
    
    public static boolean isNum(char c) {
        return c >= '0' && c <='9';
    }
}
