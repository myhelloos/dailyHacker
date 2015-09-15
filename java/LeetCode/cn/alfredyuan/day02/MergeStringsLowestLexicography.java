package cn.alfredyuan.day02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接所有字符串产生字典顺序最小的大字符串
 * 
 * 证明最关键的步骤是证明这种比较的方式具有传递性。 假设有a,b,c三个字符串，他们有如下的关系： a.b < b.a b.c < c.b
 * 所谓传递性证明是指，如果有以上的两个关系，能否证明 a.c < c.a 证明传递性过程：
 * 字符串a,b的连接记为a.b，如果将字符串看做一个K进制数，那么字符串之间的加减乘除都可以按照数字的方式进行。
 * 那么a.b这个字符串中a作为高位，b作为低位，可以进行如下的替换 a.b =
 * a*(K^length(b))+b。其中a*(K^length(b))表示，a这个K进制数，向左位移了b的长度。
 * 我们现在把K^length(b)记为moveBit(b)，则a.b = a*moveBit(b)+b，那么 a.b
 * < b.a => a*moveBit(b)+b < b*moveBit(a)+a 不等式1 b.c < c.b => b*moveBit(c)+c <
 * c*moveBit(b)+b 不等式2 现在要证明a.c < c.a，也就是证明a*moveBit(c)+c < c*moveBit(a)+a
 * 我们把不等式1的左右两边同时减去b再乘以c，则不等式1可以变形为： a*moveBit(b)*c < b*moveBit(a)*c+a*c-b*c
 * 我们把不等式2的左右两边同时减去b再乘以a，则不等式2可以变形为： b*moveBit(c)*a+c*a-b*a < c*moveBit(b)*a
 * 现在a,b,c都是K进制数，所以服从乘法交换律。 所以不等式1中的a*moveBit(b)*c等于不等式2中的c*moveBit(b)*a。
 * 所以，b*moveBit(c)*a+c*a-b*a < b*moveBit(a)*c+a*c-b*c 所以，b*moveBit(c)*a-b*a <
 * b*moveBit(a)*c-b*c 所以，a*moveBit(c)-a < c*moveBit(a)-c 所以，a*moveBit(c)+c <
 * c*moveBit(a)+a => a.c < c.a 证明a.c < c.a完成。
 * 现在我们知道这种比较大小的方式是有传递性的，那么根据这种传递性可知，在一个排序过的序列中，任意两个字符串Str1与Str2，只要Str1排在Str2的前面，就有Str1.Str2
 * < Str2.Str1。
 * 好，现在我们有了传递性，接下来需要证明：在通过这种排序方式之后所得到的字符串序列中，交换任意两个字符串之后的那个总字符串，都会比未交换前的那个总字符串，拥有更大的字典顺序。
 * 假设通过如上的比较方式，我们得到了一组字符串的序列：…A.M1.M2…M(n-1).M(n).L…，该序列表示，代号为A的字符串之前和代号为L的字符串之后都有若干字符串，A和L中间有若干字符串（用M1..M(n)表示）。
 * 现在我们交换A和L这两个字符串，那么交换之前和交换之后两个总字符串就分别为： …A.M1.M2…M(n-1).M(n).L… 换之前
 * …L.M1.M2…M(n-1).M(n).A… 换之后 现在我们需要证明换之后的总字符串字典顺序大于换之前的。 证明：
 * 因为在原始序列中，M1排在L的前面，所以有M1.L<L.M1，所以有…L.M1.M2…M(n-1).M(n).A… >
 * …M1.L.M2…M(n-1).M(n).A…
 * 因为在原始序列中，M2排在L的前面，所以有M2.L<L.M2，所以有…M1.L.M2…M(n-1).M(n).A… >
 * …M1.M2.L…M(n-1).M(n).A… … 所以有：…M1.M2…M(n-1).M(n).L.A… >
 * …M1.M2…M(n-1).M(n).A.L…
 * 因为在原始序列中，A排在M(n)的前面，所以有A.M(n)<M(n).A，所以有…M1.M2…M(n-1).M(n).A.L… >
 * …M1.M2…M(n-1).A.M(n).L… … 所以有：…M1.A.M2…M(n-1).M(n).L… >
 * …A.M1.M2…M(n-1).M(n).L… 通过上面不等式之间的连接，可证明换之后>换之前，证明结束，该方法有效。
 * 
 * @author alfred
 *
 */
class MergeComparator implements Comparator<String> {
  @Override
  public int compare(String arg0, String arg1) {
    return (arg0 + arg1).compareTo(arg1 + arg0);
  }
}

public class MergeStringsLowestLexicography {
  public static String lowestString(String[] strs) {
    Arrays.sort(strs, new MergeComparator());
    StringBuilder res = new StringBuilder();
    for (int i = 0; i != strs.length; i++) {
      res.append(strs[i]);
    }
    return res.toString();
  }

  public static void main(String[] args) {
    String[] strArr = { "jibw", "ji", "jp", "bw", "jibw" };
    String result = lowestString(strArr);
    System.out.println(result);
  }
}
