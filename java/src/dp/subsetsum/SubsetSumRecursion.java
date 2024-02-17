package dp.subsetsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSumRecursion {


    public static void main(String[] args) {

    }

    /*

     */
    static void returnSubsetsWithSumK(int[] input, int n, int k, List<List<Integer>> subsets, List<Integer> curr) {

        if (k == 0) {
            printList(curr);
            return;
        }
        if (k< 0 || n<0) {
            return;
        }
        returnSubsetsWithSumK(input, n - 1, k, subsets, curr);
        curr.add(input[n]);
        returnSubsetsWithSumK(input, n - 1, k - input[n], subsets, curr);
    }

    static void printList(List<Integer> list){
       String a = list.stream().map(i->i.toString()).collect(Collectors.joining(", "));
       System.out.println(a);
    }
}


