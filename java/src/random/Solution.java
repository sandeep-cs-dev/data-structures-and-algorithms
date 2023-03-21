package random;


class Solution {


    public static void main (String ...args){

        int ans =new Solution().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
        System.out.println(ans);
    }
    public int findMaxConsecutiveOnes(int[] nums) {

        int ans=0;
        int currentMax=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                currentMax++;
            } else {
                ans = Math.max(ans,currentMax);
                currentMax=0;
            }

        }
        ans = Math.max(ans,currentMax);
        return ans;
    }
}