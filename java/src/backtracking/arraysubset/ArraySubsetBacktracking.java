package backtracking.arraysubset;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySubsetBacktracking {

    public static void main(String[] args) {

        int [] array =  {1,2,3};
        Subsets(new ArrayList<>(),new ArrayList(),array,0);
    }


    public static List<List<Integer>> Subsets (List<List<Integer>>subsets,List<Integer>subset,int [] arr,int start) {
/*
                          {}
                   {1}     {2}     {3}
             {1,2}          {2,3}
        {1,2,3}   {1,3}
  */
         subsets.add(subset);
         System.out.println(Arrays.toString(subset.toArray()));
        for(int i=start;i<arr.length;i++) {
            subset.add(arr[i]);
            Subsets(subsets,subset,arr,i+1);
            subset.remove(subset.size()-1);// back tracking
        }

        return subsets;
    }

}