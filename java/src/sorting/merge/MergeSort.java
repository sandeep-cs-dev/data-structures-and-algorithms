package sorting.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int arr[] = {1, 3, 5, 7, 2, 4, 6, 8, 10};
        arr = mergeSort(arr,0,8);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] merge(int arr[], int start, int mid, int end) {
        int a[] = new int[end - start + 1];
        int fp = start;  // first part
        int sp = mid + 1;   // second part
        int x=0;
        for (int i = start; i <=end; i++) {
            /*
             * we can not put first 2 condition later why?
             *  let's say first sub array is over than arr[fp] > arr[sp]) condition will be checked against sp to sp, which we want to avoid
             *
             * */
            if (fp > mid) {   // first sub array is over
                a[x++] = arr[sp++];
            } else if (sp > end) { // means first sub array size is greater than second
                a[x++] = arr[fp++];
            } else if (arr[fp] > arr[sp]) {
                a[x++] = arr[sp++];
            } else {
                a[x++] = arr[fp++];
            }
        }
        for (int p = 0; p<x; p++) {
            arr[start+p] = a[p];
        }
        return arr;
    }

    public static int[] mergeSort(int arr[], int start, int end) {

        if (start < end) {
            int mid = (end+start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            arr =merge(arr, start, mid, end);
        }
        return arr;
    }


}
