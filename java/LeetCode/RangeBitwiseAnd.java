public class RangeBitwiseAnd {
    // https://leetcode.com/problems/bitwise-and-of-numbers-range/
    /**
    * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise
    * AND of all numbers in this range, inclusive. For example, given the range
    * [5, 7], you should return 4.
    */
    public int rangeBitwiseAnd(int m, int n) {
        int xor = m ^ n;
        int remain = xor >> 1;
        Integer.highestOneBit(m);

        while (remain != 0) {
            xor |= remain;
            remain >>= 1;
        }

        return m & n & (~xor);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(10, 16));
        System.out.println(solution.rangeBitwiseAnd(5, 5));
        System.out.println(solution.rangeBitwiseAnd(Integer.MAX_VALUE-1, Integer.MAX_VALUE));
    }

}
