/**
* 实现一个算法，确定一个字符串的所有字符是否全都不同。假如不允许使用额外的数据结构，又该如何处理
*/
import java.util.BitSet;

/**
*   假定字符集为ASCII
*/
public class EX01_1 {
    /**
    * 使用java.util.BitSet
    */
    public boolean isUniqueChars3(String str) {
        if (str.length() > 256) return false;

        BitSet flag = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (flag.get(val)) {
                return false;
            }
            flag.set(val);
        }
        return true;
    }

    /**
    * 构建一个布尔值的数组，即不使用额外的数据结构
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
        EX01_1 test_base = new EX01_1();

        if (args.length > 0) {
            String test_string = args[0];
            System.out.println("result of isUniqueChars: " + test_base.isUniqueChars(test_string));
            System.out.println("result of isUniqueChars2: " + test_base.isUniqueChars2(test_string));
            System.out.println("result of isUniqueChars3: " + test_base.isUniqueChars3(test_string));
            return;
        }
        System.err.printf("Usage: java %s String\n", test_base.getClass().getSimpleName());
    }
}
