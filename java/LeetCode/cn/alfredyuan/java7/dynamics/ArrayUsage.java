package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayUsage {
  public void useArray() {
    String[] names = (String[]) Array.newInstance(String.class, 10);
    names[0] = "Hello";
    Array.set(names, 1, "World");
    System.out.println(Arrays.deepToString(names));
    String str = (String) Array.get(names, 0);
    System.out.println(str);
    int[][][] matrix1 = (int[][][]) Array.newInstance(int.class, 3, 3, 3);
    matrix1[0][0][0] = 1;
    System.out.println(Arrays.deepToString(matrix1));
    int[][][] matrix2 = (int[][][]) Array.newInstance(int[].class, 3, 4);
    matrix2[0][0] = new int[10];
    matrix2[0][1] = new int[3];
    matrix2[0][0][1] = 1;
    Array.set(matrix2[0][1], 0, 2);
    Array.set(matrix2[1], 0, new int[2]);
    Array.set(matrix2[1][0], 1, 3);
    System.out.println(Arrays.deepToString(matrix2));
  }

  public static void main(String[] args) {
    ArrayUsage au = new ArrayUsage();
    au.useArray();
  }
}
