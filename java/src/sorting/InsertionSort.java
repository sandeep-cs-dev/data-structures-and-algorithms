package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int [] input =  {5,4,3,2,1,0,-1};
         insertionSort(input);
         Arrays.stream(input).forEach(System.out::println);
    }

    static void insertionSort(int [] input){

        for(int i=1;i<input.length;i++){
           int current = input[i];
           int j = i-1;
           while(j>=0 && input[j]>current){
               input[j+1]=input[j];    // shift the element to right
               j--;
             }
            input[j+1] = current;   // set the right position of element
        }
    }
}

