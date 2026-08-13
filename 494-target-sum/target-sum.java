import java.util.*;

class Solution {

    int[][] dp;

    int helper(int n, int[] nums, int target) {

        if(n < 0) {
            return target == 0 ? 1 : 0;
        }

        if(dp[n][target] != -1) {
            return dp[n][target];
        }

        int nottake = helper(n - 1, nums, target);

        int take = 0;

        if(nums[n] <= target) {
            take = helper(n - 1, nums, target - nums[n]);
        }

        return dp[n][target] = take + nottake;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(Math.abs(target) > sum) {
            return 0;
        }

        if((sum + target) % 2 != 0) {
            return 0;
        }

        int newtarget = (sum + target) / 2;

        dp = new int[nums.length][newtarget + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums.length - 1, nums, newtarget);
    }
}