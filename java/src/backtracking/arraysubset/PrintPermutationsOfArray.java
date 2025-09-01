package backtracking.arraysubset;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintPermutationsOfArray {


    public static void main( String [] args) {
        printPermutation(new int[]{1,2,3},0);
    }


    public static void printPermutation( int [] input, int i ) {

        if(i==input.length){
            System.out.println(Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }

        /*

          make a choice to for first place, then repeat the process for remaining slots ie recurse
          1 (--)

            then backtrack (put array in previous state and then

         */


        for(int j=i;j<input.length;j++) {
             swap(i,j,input);
             printPermutation(input,i+1);
             swap(i,j,input); // back track
        }
    }
    public static void swap (int i, int j, int [] input) {
        int tmp =  input[i];
        input[i]= input[j];
        input[j]=tmp;
    }
}
