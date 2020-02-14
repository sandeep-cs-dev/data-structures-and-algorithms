package heap;

import java.util.Arrays;

public class Heap {
    //int arr[];

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       // System.out.println(Arrays.toString(arr));
         buildMaxHeap(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] swap(int arr[], int index1, int index2) {

        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] =tmp;
        return  arr;
    }

    static public  int [] buildMaxHeap(int arr[]) {
        int len = (arr.length)/2-1; //assuming arr length is > 3
        for(int i=len;i>=0;i--) {
          System.out.println("iiii"+i);
          System.out.println(Arrays.toString(arr));
          arr = heapify(arr,i);
          //System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    static int [] heapify(int arr[], int nodeInd) {
        int left = 2 * nodeInd + 1;
        int right = 2 * nodeInd + 2;
        int len = arr.length;
        int maxInd=-1;
        if (left < len && arr[left] > arr[nodeInd]) {
            maxInd = left;
        }
         else maxInd =nodeInd;

        if (right < len && arr[right] > arr[maxInd])
            maxInd = right;

        if(maxInd!=nodeInd && maxInd>=0) {
            arr = swap(arr, maxInd, nodeInd);
            //System.out.println(Arrays.toString(arr));
            arr =  heapify(arr, maxInd);
        }
        return arr;
}
}
