package cn.alfredyuan.day05;
/**
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，
 * 
 * @author alfred.yx
 * @version v 0.1 Sep 21, 2015 4:55:00 PM alfred Exp $
 */
// 动态规划的空间优化方法
public class MinPathInMatrix {
    public int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
                return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col]; // dp[row][col]中dp[i][j]为m[0][0]到m[i][j]的最短路径和
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) { // dp[*][0]赋初值
               dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) { // dp[0][*]赋初值
               dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) { // dp[i][j]的最短路径和为dp[i][j-1]和dp[i-1][j]的较小值与m[i][j]的和
               for (int j = 1; j < col; j++) {
                   dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
               }
        }
        return dp[row - 1][col - 1];
      }

    // 使用一维数组滚动跟新dp上的结果
    public int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
                return 0;
        }
        int more = Math.max(m.length, m[0].length); // 行数与列数较大的为more
        int less = Math.min(m.length, m[0].length); // 行数与列数较小的为less
        boolean rowmore = more == m.length; // 行数是不是大于等于列数
        int[] arr = new int[less]; // 辅助数组的长度经纬行数与列数中的最小值
        arr[0] = m[0][0];
        // 为arr赋初值
        for (int i = 1; i < less; i++) {
                arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        // 滚动更新
        for (int i = 1; i < more; i++) {
               arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
               for (int j = 1; j < less; j++) {
                       arr[j] = Math.min(arr[j - 1], arr[j])
                                      + (rowmore ? m[i][j] : m[j][i]);
               }
        }
        return arr[less - 1];
      }
}
