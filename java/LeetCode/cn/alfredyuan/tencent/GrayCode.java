package cn.alfredyuan.tencent;

import java.util.HashMap;

public class GrayCode {
  HashMap<K, V>
  public static int[] grayCode(int N) {
    if (N <= 0) throw new IllegalArgumentException("the N must be positive");
    int[] code = new int[N];
    grayCode(N, code);
    return code;
  }

  private static void grayCode(int n, int[] code) {
    if (1 == n) {
      code[0] = (int)(Math.random() * Integer.MAX_VALUE);
    } else {
      grayCode(n-1, code);
      code[n-1] = changeOnePosition(code[n-2]);
    }
  }

  private static int changeOnePosition(int i) {
    // the integer contains 32 positions that can be changed
    int position = (int) (Math.random() * 32);
    int result = i ^ (1 << position);
    return result;
  }
}
