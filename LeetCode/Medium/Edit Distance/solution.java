class Solution {
    int helper(int i,int j,String s1, String s2,int[][] dp){
        if(i<0)return j+1;
        if(j<0)return i+1;

        if(dp[i][j]!=-1)return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))return dp[i][j]=helper(i-1,j-1,s1,s2,dp);

        int a=1+helper(i-1,j,s1,s2,dp);

        return dp[i][j]=Math.min(a,Math.min(1+helper(i,j-1,s1,s2,dp),1+helper(i-1,j-1,s1,s2,dp)));
    }

    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        int[][] dp=new int[n1][n2];

        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(n1-1,n2-1,word1,word2,dp);
    }
}