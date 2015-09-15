package cn.alfredyuan.day01;

public class ReverseString {
  public static void reverse(char[] chas, int start, int end) {
    char tmp = 0;
    while (start < end) {
      tmp = chas[start];
      chas[start] = chas[end];
      chas[end] = tmp;
      start++;
      end--;
    }
  }

  public static void rotate1(char[] chas, int size) {
    if (chas == null || size <= 0 || size >= chas.length) {
      return;
    }
    reverse(chas, 0, size - 1);
    reverse(chas, size, chas.length - 1);
    reverse(chas, 0, chas.length - 1);
  }

  public static void rotate2(char[] chas, int size) {
    if (chas == null || size <= 0 || size >= chas.length) {
      return;
    }
    int start = 0;
    int end = chas.length - 1;
    int lpart = size;
    int rpart = chas.length - size;
    int s = Math.min(lpart, rpart);
    int d = lpart - rpart;
    while (true) {
      exchange(chas, start, end, s);
      if (d == 0) {
        break;
      } else if (d > 0) {
        start += s;
        lpart = d;
      } else {
        end -= s;
        rpart = -d;
      }
      s = Math.min(lpart, rpart);
      d = lpart - rpart;
    }
  }

  public static void exchange(char[] chas, int start, int end, int size) {
    int i = end - size + 1;
    char tmp = 0;
    while (size-- != 0) {
      tmp = chas[start];
      chas[start] = chas[i];
      chas[i] = tmp;
      start++;
      i++;
    }
  }
  
  
}
