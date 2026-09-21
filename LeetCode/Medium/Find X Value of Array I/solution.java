class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            long[] curr = new long[k];

            int value = num % k;

      
            curr[value]++;

          
            for (int r = 0; r < k; r++) {

                int newRemainder = (r * value) % k;

                curr[newRemainder] += dp[r];
            }

            dp = curr;

            
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}