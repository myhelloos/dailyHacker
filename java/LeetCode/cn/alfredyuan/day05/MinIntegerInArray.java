package cn.alfredyuan.day05;

/**
 * 给定一个无序数组arr,求出数组中未出现的最小正整数
 * 
 * @author alfred.yx
 * @version v 0.1 Sep 21, 2015 3:08:46 PM alfred Exp $
 */
public class MinIntegerInArray {
    public int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
           if (arr[l] == l + 1) {
                   l++;
           } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                   arr[l] = arr[--r];
           } else {
                   swap(arr, l, arr[l] - 1);
           }
        }
        return l + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
