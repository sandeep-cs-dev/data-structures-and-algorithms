package backtracking.arraysubset;

class CombinationSum {
    public static void main(String[] args) {
        int ans = new CombinationSum().combinationSum4(new int[]{2,2, 3, 6, 7}, 7, 0);
        System.out.println(ans);
    }

    public int combinationSum4(int[] nums, int target, int start) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = start; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i], i);
            }
        }
        return res;
    }
}
