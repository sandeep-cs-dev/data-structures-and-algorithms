package sorting.quiksort;

import java.util.Arrays;

public class QuickSort {
    static int arr[];

    public static void main(String args[]) {
        int a[] = {2, 56, -1,0,9,25};
        arr = a;
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] swap(int ar[], int index1, int index2) {

        int tmp = ar[index1];
        ar[index1] = ar[index2];
        ar[index2] = tmp;
        arr = ar;
        return arr;
    }

    public static int partition(int l, int h) {
        int partition = -1;
        int pivot = arr[l];
        int i = l;
        int j = h;
        while (i<j) {   // no longer need to swap i and j we found correct position of pivot that is partition index
            while ( i <arr.length && arr[i] <= pivot) {
                i++;
            }
            while (j>=0 && arr[j] > pivot)  {
                j--;
               // System.out.println("jjj "+j);
            }
            if (i<j) {
                arr =swap(arr, i, j);
                System.out.println("sp"+Arrays.toString(arr));
            }
        }
        arr = swap(arr,l, j);
        partition = j;
        return partition;
    }

    public static int[] quickSort(int arr[], int l, int h) {
        if (l < h) {
            int partition = partition(l, h);
            System.out.println("dsdd"+partition);
            quickSort(arr, l, partition);
            quickSort(arr, partition + 1, h);
        }
        return arr;

    }
}
