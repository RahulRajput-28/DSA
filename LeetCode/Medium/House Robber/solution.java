class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }

    int helper(int index,int[] nums,int[] dp){
        if(index==nums.length-1){
            return nums[index];
        }

        if(index>=nums.length){
            return 0;
        }

        if(dp[index]!=-1)return dp[index];

        int take=nums[index]+helper(index+2,nums,dp);

        int notTake=helper(index+1,nums,dp);

        return dp[index]=Math.max(take,notTake);
    }
}