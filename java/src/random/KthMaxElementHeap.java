package random;

import java.util.Arrays;

public class KthMaxElementHeap {

    public static void main(String[] args) {
        int[] input = { 4, 2,1,0,6};
        //Arrays.stream(input).forEach(System.out::println);
        var ans = findKthMaxElement(3,input);
        System.out.println("kth max element is:"+ans);
    }

   public static int findKthMaxElement (int k, int [] input){

        //buildMinHeap(input);

       // maintain heap of size k
       // when size of heap is less than k just insert and hea
         var heapOfK =   new int[k];
         int ind=0;
         for( int i=0;i<input.length;i++){

           if(heapOfK.length<k){
             heapOfK[ind++]= input[i];
            if(ind==k)
             heapify(0,heapOfK,k);
           } else {
              if(heapOfK[0]<input[i]){
                  heapOfK[0]=input[i];
                  heapify(0,heapOfK,k);
              }
           }
         }
         return heapOfK[0];
    }

  public static void buildMinHeap(int [] input){

    int lastNonLeafIndex = input.length/2 -1;

      for(int i=lastNonLeafIndex;i>=0;i--){
          heapify(i,input,input.length);
      }
    Arrays.stream(input).forEach(System.out::println);
  }


   public  static void heapify(int index, int [] input, int k){

       int min = index;
       int left =  2*index+1;
       int right = 2*index+2;
       if(left<k && input[min]>input[left]){
           min=left;
       }
       if(right<k && input[min]>input[right]){
          min =right;
       }
       if(min!=index){
        int temp = input[min];
        input[min] = input[index];
        input[index]=temp;
        heapify(min,input,k);
       }
   }

}