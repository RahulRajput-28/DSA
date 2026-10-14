class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= helper(0,coins,amount,dp);
        

        return ans==Integer.MAX_VALUE/2 ? -1 : ans;
    }

    int helper(int index,int[] coins, int amount,int[][] dp){
        if(amount==0 ){
            return dp[index][amount]=0;
        }

        if(amount<0 || index>=coins.length  ){
            return Integer.MAX_VALUE/2;
        }

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        int take=1+helper(index,coins,amount-coins[index],dp);

        int notTake=helper(index+1,coins,amount,dp);

        return dp[index][amount]=Math.min(take,notTake);


    }
}