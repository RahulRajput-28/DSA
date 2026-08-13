class Solution {
    int helper(int n,int[] coins,int target,int[][] dp){
        if(target==0)return 1;
        if(n==0){
            if(target%coins[n]==0){
                return 1;
            }
            return 0;
        }

        if(dp[n][target]!=-1){
            return dp[n][target];
        }

        int nottake=helper(n-1,coins,target,dp);
        int take=0;
        if(coins[n]<=target){
            take=helper(n,coins,target-coins[n],dp);
        }

        return dp[n][target]=nottake+take;
    }

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= helper(n-1,coins,amount,dp);
        return ans;
    }
}