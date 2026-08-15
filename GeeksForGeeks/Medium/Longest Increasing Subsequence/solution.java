class Solution {

    int helper(int index, int prev, int[] arr, int[][] dp) {

        if(index == arr.length)
            return 0;

        if(dp[index][prev + 1] != -1)
            return dp[index][prev + 1];

        int nottake = helper(index + 1, prev, arr, dp);

        int take = 0;

        if(prev == -1 || arr[index] > arr[prev]) {
            take = 1 + helper(index + 1, index, arr, dp);
        }

        return dp[index][prev + 1] = Math.max(nottake, take);
    }

    public int lis(int arr[]) {

        int n = arr.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, -1, arr, dp);
    }
}