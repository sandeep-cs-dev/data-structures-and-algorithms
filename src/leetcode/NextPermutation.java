package leetcode;
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length-1;
        int i=len-1;
        while(i>=0 && nums[i]>=nums[i+1])i--;
        if(i>=0){
            int j= len;
            while(nums[j]<=nums[i])j--;
            this.swap(nums,i,j);
        }
        this.reverse(nums,i+1,len);
    }
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
