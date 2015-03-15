/**
* 实现一个算法，确定一个字符串的所有字符是否全都不同。假如不允许使用额外的数据结构，又该如何处理
*/
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
*   假定字符集为ASCII
*/
public class EX01 {
    /**
    * 构建一个布尔值的数组
    */
    public boolean isUniqueChars2(String str) {
        if (str.length() > 256) return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
    * 使用位向量(bit vector)，假设字符串只含有小写字母a到z
    */
    public boolean isUniqueChars(String str) {
        if (str.length() > 256) return false;

        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((flag & (1 << val)) != 0) {
                return false;
            }
            flag |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        EX01 test_base = new EX01();

        System.out.println("Testing Begins:");
        String[] test_string = new String[10];
        Random rand = new Random();
        for (int i = 0; i < test_string.length; i++) {
            int random_len = rand.nextInt(256);
            test_string[i] = random(random_len);
        }
        for (int i = 0; i < test_string.length; i++) {
            System.out.println(test_string[i]);
            System.out.println("result of isUniqueChars: " + test_base.isUniqueChars(test_string[i]));
            System.out.println("result of isUniqueChars2: " + test_base.isUniqueChars2(test_string[i]));
        }
    }

    /** 产生一个随机的字符串，适用于JDK 1.7 */
    public static String random(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (ThreadLocalRandom.current().nextInt(33, 128)));
        }
        return builder.toString();
    }
}
