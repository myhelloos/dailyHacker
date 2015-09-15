package cn.alfredyuan.day01;

/**
 *  给定⼀个字符串str和它的⼀个最长回⽂⼦序列strLPS，返回字符串str在任意 位置添加最少字符后，
 *  整体都是回⽂串的其中⼀种结果。 
 *      例如： str="AB1C2DE34F3GHJ21KL"; strLPS="1234321";
 *      返回："ABLK1C2DEJHG3F4F3GHJED2C1KLBA" 
 * @author alfred
 *
 */
public class Palindrome {
  public String getPalindrome(String str, String strlps) {
    if (str == null || str.equals("")) {
      return "";
    }
    char[] chas = str.toCharArray();
    char[] lps = strlps.toCharArray();
    char[] res = new char[2 * chas.length - lps.length];
    int chasl = 0;
    int chasr = chas.length - 1;
    int lpsl = 0;
    int lpsr = lps.length - 1;
    int resl = 0;
    int resr = res.length - 1;
    int tmpl = 0;
    int tmpr = 0;
    while (lpsl <= lpsr) {
      tmpl = chasl;
      tmpr = chasr;
      while (chas[chasl] != lps[lpsl]) {
        chasl++;
      }
      while (chas[chasr] != lps[lpsr]) {
        chasr--;
      }
      set(res, resl, resr, chas, tmpl, chasl, chasr, tmpr);
      resl += chasl - tmpl + tmpr - chasr;
      resr -= chasl - tmpl + tmpr - chasr;
      res[resl++] = chas[chasl++];
      res[resr--] = chas[chasr--];
      lpsl++;
      lpsr--;
    }
    return String.valueOf(res);
  }

  private void set(char[] res, int resl, int resr, char[] chas, int ls, int le,
      int rs, int re) {
    for (int i = ls; i < le; i++) {
      res[resl++] = chas[i];
      res[resr--] = chas[i];
    }
    for (int i = re; i > rs; i--) {
      res[resl++] = chas[i];
      res[resr--] = chas[i];
    }
  }

  public static void main(String... args) {
    Palindrome solution = new Palindrome();
    String str = "AB1C2DE34F3GHJ21KL";
    String strLPS = "1234321";
    System.out.println(solution.getPalindrome(str, strLPS));
  }
}
