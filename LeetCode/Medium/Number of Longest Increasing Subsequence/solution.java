class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxi=0;
        int[] count=new int[nums.length];
        int[] dp=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                }else if(nums[j]<nums[i] && dp[i]==dp[j]+1){
                    count[i]+=count[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        
        int ans = 0;

        for(int i = 0; i < dp.length; i++) {
            if(dp[i] == maxi) {
                ans += count[i];
            }
        }

        return ans;

    }
}