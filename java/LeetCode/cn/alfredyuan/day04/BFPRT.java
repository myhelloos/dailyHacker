package cn.alfredyuan.day04;

/**
 * 找到无序数组中最小的K个数 
 * 【题目】
 *  给定一个无序的整型数组arr，找到其中最小的k个数。 
 * 【要求】
 *  如果数组arr的长度为N，排序之后自然可以得到最小的k个数，此时时间复杂度为排序的时间复杂度即O(N*logN)。
 *  本题要求读者实现时间复杂度O(N*logK)和O(N)的方法。
 * 
 * @author alfred
 *
 */
public class BFPRT {
  public int[] getMinKNumsByBFPRT(int[] arr, int k) {
    if (k < 1 || k > arr.length) {
      return arr;
    }
    int minKth = getMinKthByBFPRT(arr, k);
    int[] res = new int[k];
    int index = 0;
    for (int i = 0; i != arr.length; i++) {
      if (arr[i] < minKth) {
        res[index++] = arr[i];
      }
    }
    for (; index != res.length; index++) {
      res[index] = minKth;
    }
    return res;
  }

  private int getMinKthByBFPRT(int[] arr, int K) {
    int[] copyArr = copyArray(arr);
    return select(copyArr, 0, copyArr.length - 1, K - 1);
  }

  private int[] copyArray(int[] arr) {
    int[] res = new int[arr.length];
    for (int i = 0; i != res.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  private int select(int[] arr, int begin, int end, int i) {
    if (begin == end) {
      return arr[begin];
    }
    int pivot = medianOfMedians(arr, begin, end);
    int[] pivotRange = partition(arr, begin, end, pivot);
    if (i >= pivotRange[0] && i <= pivotRange[1]) {
      return arr[i];
    } else if (i < pivotRange[0]) {
      return select(arr, begin, pivotRange[0] - 1, i);
    } else {
      return select(arr, pivotRange[1] + 1, end, i);
    }
  }

  private int medianOfMedians(int[] arr, int begin, int end) {
    int num = end - begin + 1;
    int offset = num % 5 == 0 ? 0 : 1;
    int[] mArr = new int[num / 5 + offset];
    for (int i = 0; i < mArr.length; i++) {
      int beginI = begin + i * 5;
      int endI = beginI + 4;
      mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
    }
    return select(mArr, 0, mArr.length - 1, mArr.length / 2);
  }

  private int[] partition(int[] arr, int begin, int end, int pivotValue) {
    int small = begin - 1;
    int cur = begin;
    int big = end + 1;
    while (cur != big) {
      if (arr[cur] < pivotValue) {
        swap(arr, ++small, cur++);
      } else if (arr[cur] > pivotValue) {
        swap(arr, cur, --big);
      } else {
        cur++;
      }
    }
    int[] range = new int[2];
    range[0] = small + 1;
    range[1] = big - 1;
    return range;
  }

  private int getMedian(int[] arr, int begin, int end) {
    insertionSort(arr, begin, end);
    int sum = end + begin;
    int mid = (sum / 2) + (sum % 2);
    return arr[mid];
  }

  private void insertionSort(int[] arr, int begin, int end) {
    for (int i = begin + 1; i != end + 1; i++) {
      for (int j = i; j != begin; j--) {
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
        } else {
          break;
        }
      }
    }
  }

  private void swap(int[] arr, int index1, int index2) {
    int tmp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tmp;
  }
}
