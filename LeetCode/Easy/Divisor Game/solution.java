class Solution {
    boolean helper(int n,boolean[] dp){
        if(dp[n]!=false)return dp[n];
        for(int x=1;x<n;x++){
            if(n%x==0){
                if(!helper(n-x,dp)){
                    return dp[n]=true;
                }
            }
        }
        return dp[n]=false;
    }

    public boolean divisorGame(int n) {
        boolean[] dp=new boolean[n+1];
        return helper(n,dp);
    }
}