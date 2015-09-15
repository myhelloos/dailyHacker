package cn.alfredyuan.leetcode;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author alfred
 *
 */
public class KCombinationOutOfNNumbers {
  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    for (int i = n; i >= k; --i) {
      ArrayList<Integer> integers = new ArrayList<>();
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      combineHelper(i, k, integers, list);
      result.addAll(list);
    }
    return result;
  }

  private void combineHelper(int n, int k, ArrayList<Integer> integers,
      ArrayList<ArrayList<Integer>> list) {
    if (n == k) {
      for (int i = n; i > 0; --i) {
        integers.add(i);
      }
      list.add(integers);
    } else if (1 == k) {
      for (int i = n; i > 0; --i) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> temp = (ArrayList<Integer>) integers.clone();
        temp.add(i);
        list.add(temp);
      }
    } else if (1 <= n - k) {
      integers.add(n);
      combineHelper(n - 1, k - 1, integers, list);
    }
  }

  public static void main(String... args) {
    System.out.println(new KCombinationOutOfNNumbers().combine(5, 3));
  }
}
