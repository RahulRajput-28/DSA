class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0) {
                    dp[j] = Math.min(dp[j], dp[i] + costs[j - 1] + k * k);
                }
            }
        }
        return dp[n];
    }
}