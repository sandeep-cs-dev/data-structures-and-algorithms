package backtracking.arraysubset;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySubsetBacktracking2 {

    public static void main(String[] args) {

        int [] array =  {1,2,3};
        subsets(new ArrayList(),array,0);
    }


    public static void subsets (List<Integer>subset,int [] arr,int ind) {
/*
                          {}
                   {1}     {2}     {3}
             {1,2}          {2,3}
        {1,2,3}   {1,3}
  */
          if(ind==arr.length) {
             System.out.println(subset);
             return;
         }
         //  select
            subset.add(arr[ind]);
            subsets(subset,arr,ind+1);
            //backtrack
            subset.remove(subset.size()-1);
            subsets(subset,arr,ind+1);
    }

}