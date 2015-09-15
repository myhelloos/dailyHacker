package cn.alfredyuan.day04;

/**
 * 【进阶题目】
 * 给定一个字符串str，想通过添加字符的方式使得str整体都变成回文字符串，但要求只能在str的末尾添加字符，请返回在str后面添加的最短字符串。 【举例】
 * str=“12”。在末尾添加“1”之后，str变为“121”是回文串。在末尾添加“21”之后，str变为“1221”也是回文串。但“1”
 * 是所有添加方案中最短的，所以返回“1”。 【要求】 如果str长度为N，解决原问题和进阶问题的时间复杂度都达到O(N)。
 * 
 * @author alfred
 *
 */
public class PalindromeByPending {
  public String shortestEnd(String str) {
    if (str == null || str.length() == 0) {
      return null;
    }
    char[] charArr = manacherString(str);
    int[] pArr = new int[charArr.length];
    int index = -1;
    int pR = -1;
    int maxContainsEnd = -1;
    for (int i = 0; i != charArr.length; i++) {
      pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
      while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
        if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
          pArr[i]++;
        else {
          break;
        }
      }
      if (i + pArr[i] > pR) {
        pR = i + pArr[i];
        index = i;
      }
      if (pR == charArr.length) {
        maxContainsEnd = pArr[i];
        break;
      }
    }
    char[] res = new char[str.length() - maxContainsEnd + 1];
    for (int i = 0; i < res.length; i++) {
      res[res.length - 1 - i] = charArr[i * 2 + 1];
    }
    return String.valueOf(res);
  }
  
  private char[] manacherString(String str) {
    char[] charArr = str.toCharArray();
    char[] res = new char[str.length() * 2 + 1];
    int index = 0;
    for (int i = 0; i != res.length; i++) {
      res[i] = (i & 1) == 0 ? '#' : charArr[index++];
    }
    return res;
  }
}
