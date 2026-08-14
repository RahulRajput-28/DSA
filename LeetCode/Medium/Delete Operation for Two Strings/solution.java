class Solution {
    int helper(int n1,int n2,String s1,String s2,int[][] dp){
        if(n1<0 || n2<0)return 0;

        if(dp[n1][n2]!=-1)return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2)){
            return 1+helper(n1-1,n2-1,s1,s2,dp);
        }

        return dp[n1][n2]=Math.max(helper(n1-1,n2,s1,s2,dp),helper(n1,n2-1,s1,s2,dp));
    }

    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp=new int[n1][n2];

        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        int len=helper(n1-1,n2-1,word1,word2,dp);
        return n1-len+(n2-len);
    }
}