package leetcode.arrays;

public class SearchInRottedArray {

    public static void main(String[] args) {

        int [] input = new int[] {6,7,8,9,0,1,2};
        int index =new Solution().search(input,0);
        System.out.println(index);
    }
}

class Solution {
    public int search(int[] nums, int target) {

        int start =0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = (end-start)/2+start;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target< nums[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(nums[mid]<=target && target<=nums[end]){
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}