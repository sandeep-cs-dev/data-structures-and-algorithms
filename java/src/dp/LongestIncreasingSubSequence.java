package dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {




    public static void main(String[] args) {

        int [] arr =  {1,2,0,3,2,4,5,0,3};
        // int [] arr = {-1,0,0,1};

        int ans = new  LongestIncreasingSubSequence().FindLongestIncreasingSubsequence(arr);
        System.out.println(ans);
    }

    public Integer FindLongestIncreasingSubsequence (int [] input){
        int [] LIS = new int[input.length];
        int ans=0;
        Arrays.fill(LIS,1);
        /**
         * LIS[i] indicate longest increasing subsequence ending at input[i], including input[i]
         *
         */
        for(int i=1;i<input.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(input[j]<input[i]) {
                    // find max of(LIS[0] ... to LIS[j])
                    max = Math.max(max, LIS[j]);
                }
            }
            LIS[i]= max+1;
            ans = Math.max(ans,LIS[i]);
        }
        return ans;
    }
}




