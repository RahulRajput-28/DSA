class Solution {
    int sum(int i,int[] nums,int[] dp){
        if(i==0)return nums[i];
        if(i<0)return 0;

        if(dp[i]!=-1)return dp[i]; 
        int pick=sum(i-2,nums,dp)+nums[i];
        int notpick=sum(i-1,nums,dp);
        return dp[i]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int left=sum(n-1,nums,dp);
        int right=sum(n-2,nums,dp);
        

        return  Math.max(left,right);
    }
}