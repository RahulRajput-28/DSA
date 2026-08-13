class Solution {
    int helper(int index,int[] coins, int target,int[][] dp){
        if(index==0){
           if(target%coins[index]==0){
            return target/coins[index];
           }else{
            return Integer.MAX_VALUE;
           }
        }

        if(dp[index][target]!=-1)return dp[index][target];

        int nottake=helper(index-1,coins,target,dp);
        int take=Integer.MAX_VALUE;
        if(coins[index]<=target){
            take=helper(index,coins,target-coins[index],dp);

            if(take!=Integer.MAX_VALUE){
                take=1+take;
            }
        }

        return dp[index][target]=Math.min(nottake,take);
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        int[][] dp=new int[n][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= helper(n-1,coins,amount,dp);

        

        return ans==Integer.MAX_VALUE ? -1 :ans;
    }
}