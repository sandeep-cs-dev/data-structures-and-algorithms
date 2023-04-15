package leetcode;

class JumpGame {
    public boolean canJump(int[] nums) {

        int maxReach = 0;
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (nums[i] == 0 && maxReach <= i) {
                return false;
            }
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}