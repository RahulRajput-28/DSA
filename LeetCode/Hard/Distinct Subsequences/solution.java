class Solution {
    int helper(int i,int j,String s, String t,int[][] dp){
        if(j<0)return 1;
        if(i<0)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(i-1,j-1,s,t,dp)+helper(i-1,j,s,t,dp);
        }else{
            return dp[i][j]=helper(i-1,j,s,t,dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();

        int[][] dp=new int[n1][n2];

        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n1-1,n2-1,s,t,dp);
    }
}