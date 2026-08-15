class Solution {
    boolean helper(int i,int j,String s, String p,Boolean[][] dp){
        if(i<0){
            while(j>=0){
                if(p.charAt(j)!='*'){
                    return false;
                }
                j--;
            }
            return true;
        }
        if(j<0 && i>=0)return false;

        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==p.charAt(j) )return dp[i][j]=helper(i-1,j-1,s,p,dp);

        if(p.charAt(j)=='*'){
            return dp[i][j]=helper(i-1,j,s,p,dp) || helper(i,j-1,s,p,dp);
        }else if(p.charAt(j)=='?'){
            return dp[i][j]=helper(i-1,j-1,s,p,dp);
        }else{
            return dp[i][j]=false;
        }
    }

    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();

        Boolean[][] dp=new Boolean[n1][n2];

        return helper(n1-1,n2-1,s,p,dp);
    }
}