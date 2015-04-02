import java.util.Scanner;

public class hihocoder_mergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        int[] arr = new int[times];
        // int result = 0;
        for (int i = 0; i < times; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(iterativeMergesort(arr));
    }

    public static int iterativeMergesort(int[] a) {
        int[] aux = new int[a.length];
        int result = 0;
        for (int blockSize=1; blockSize<a.length; blockSize*=2) {
            for (int start=0; start<a.length; start+=2*blockSize) {
                result = merge(a, aux, start, start+blockSize, start+2*blockSize, result);
            }
        }
        return result;
    }

    private static int merge(int[] a, int[] aux, int lo, int mid, int hi, int result) {
        if (mid >= a.length) return result;
        if (hi > a.length) hi = a.length;
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)     aux[k] = a[j++];
            else if (j == hi)      aux[k] = a[i++];
            else if (a[i] < a[j])  aux[k] = a[i++];
            else {
                aux[k] = a[j++];
                result += mid - i;
            }

        }
        for (int k = lo; k < hi; k++) {
            a[k] = aux[k];
        }
        return result;
    }
}
