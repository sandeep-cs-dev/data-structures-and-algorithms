package leetcode;

import java.util.*;

public class TwoSum {

    public static void main(String args[]) {

     int nums[] = {1,3,6};
//        int arr[] = twoSum(nums, 6);
          int t =15;

      int ans = minPurchases(nums,15);
      System.out.println(ans);
    }
//
//    public static int[] twoSum(int[] nums, int target) {
//
//
//        Map<Integer, Integer> numPosition = new HashMap<Integer, Integer>();
//
//        Arrays.sort(nums);
//
//
//
//        ( ) {
//
//            int tmp = nums[left] + nums[right];
//
//            if (tmp == target) {
//                arr[0] = numPosition.get(nums[left]);
//                arr[1] = numPosition.get(nums[right]);
//                break;
//            } else if (tmp > target) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return arr;
//    }
//


    public static int minPurchases(int[] trip_durations, int total_hours) {
        int min_purchases = 0;
         Arrays.sort(trip_durations);
         Collections.reverse(Arrays.asList(trip_durations));
        for (int i = 0; i < trip_durations.length; i++) {
            if (trip_durations[i] < total_hours) {
                int m = total_hours / trip_durations[i];
                if (total_hours % trip_durations[i] == 0)
                    return min_purchases + m;
                else if (m > 0) {
                    while (m > 0) {
                        int rm = total_hours - m * trip_durations[i];
                        for (int j = i + 1; j < trip_durations.length; j++) {
                            if (rm - trip_durations[j] == 0) {
                                return min_purchases + m + 1;
                            }
                            m--;
                        }
                        if (m < 0) {
                            min_purchases++;
                            total_hours = total_hours - trip_durations[i] * min_purchases;
                        }
                    }
                }
            }
        }
            if (min_purchases == 0)
                return -1;
            return min_purchases;
    }
}