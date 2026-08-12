class Solution {
    boolean helper(int i,int target,int[] nums,Boolean[][] dp){
        if(target==0)return true;
        if(i==0)return nums[0]==target;

        if(dp[i][target]!=null)return dp[i][target];

        boolean nottake=helper(i-1,target,nums,dp);
        boolean take=false;
        if(nums[i]<=target){
            take=helper(i-1,target-nums[i],nums,dp);
        }

        return dp[i][target]=take || nottake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int m=nums.length;

        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        Boolean[][] dp=new Boolean[m][sum+1];

        if(sum%2!=0)return false;

        int target=sum/2;

        return helper(m-1,target,nums,dp);
    }
}