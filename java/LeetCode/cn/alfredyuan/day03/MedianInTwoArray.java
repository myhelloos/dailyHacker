package cn.alfredyuan.day03;

/**
 * 给定两个有序数组arr1和arr2，在给定一个整数k，返回两个数组的所有数中第K小的数。
 *      例如： arr1 = {1,2,3,4,5}; arr2 = {3,4,5}; K = 1; 因为1为所有数中最小的，所以返回1； 
 *            arr1 = {1,2,3}; arr2 = {3,4,5,6}; K = 4; 因为3为所有数中第4小的数，所以返回3；
 * 
 * 要求：如果arr1的长度为N，arr2的长度为M，时间复杂度请达到O(log(min{M,N}))。
 * 
 * @author alfred
 *
 */
public class MedianInTwoArray {
  public int findKthNum(int[] arr1, int[] arr2, int kth) {
    if (arr1 == null || arr2 == null) {
      throw new RuntimeException("Your arr is invalid!");
    }
    if (kth < 1 || kth > arr1.length + arr2.length) {
      throw new RuntimeException("K is invalid!");
    }
    int[] longArr = arr1.length >= arr2.length ? arr1 : arr2;
    int[] shortArr = arr1.length < arr2.length ? arr1 : arr2;
    int lenL = longArr.length;
    int lenS = shortArr.length;
    // 第一种情况，kth比短数组的长度小，则kth数为两个数组前kth的前中位数
    if (kth <= lenS) {
      return getUpMedian(shortArr, 0, kth - 1, longArr, 0, kth - 1);
    }
    // 第二种情况，kth比长数组的长度大，则kth数可能为：
    //  1. 短数组中kth - lensS - 1 位的数
    //  2. 长数组中kth - lensL - 1 位的数
    //  3. 两个数组中后lenS+lenL-k位数组的前中位数
    if (kth > lenL) {
      if (shortArr[kth - lenL - 1] >= longArr[lenL - 1]) {
        return shortArr[kth - lenL - 1];
      }
      if (longArr[kth - lenS - 1] >= shortArr[lenS - 1]) {
        return longArr[kth - lenS - 1];
      }
      return getUpMedian(shortArr, kth - lenL, lenS - 1, longArr, kth - lenS,
          lenL - 1);
    }
    // 第三种情况，kth在两个数组之间，则kth数可能在
    //  1. 长数组的第kth-lesS-1位
    //  2. 短数组和长数组后lenS位的前中位数
    if (longArr[kth - lenS - 1] >= shortArr[lenS - 1]) {
      return longArr[kth - lenS - 1];
    }
    return getUpMedian(shortArr, 0, lenS - 1, longArr, kth - lenS, kth - 1);
  }

  private int getUpMedian(int[] arr1, int start1, int end1, int[] arr2,
      int start2, int end2) {
    if (start1 == end1) {
      return Math.min(arr1[start1], arr2[start2]);
    }
    int offset = ((end1 - start1 + 1) & 1) ^ 1;
    int mid1 = (start1 + end1) / 2;
    int mid2 = (start2 + end2) / 2;
    if (arr1[mid1] > arr2[mid2]) {
      return getUpMedian(arr1, start1, mid1, arr2, mid2 + offset, end2);
    } else if (arr1[mid1] < arr2[mid2]) {
      return getUpMedian(arr1, mid1 + offset, end1, arr2, start2, mid2);
    } else {
      return arr1[mid1];
    }
  }
}
