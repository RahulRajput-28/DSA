class Solution {
    int helper(int n1,int n2,String s1, String s2,int[][] dp){
        int len=0;
        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    len=Math.max(len,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return len;
    }
    
    public int longCommSubstr(String s1, String s2) {
        // code here
        int n1=s1.length();
        int n2=s2.length();
        
        int[][] dp=new int[n1+1][n2+1];
        
        for(int i=0;i<n1+1;i++){
            dp[i][0]=0;
        }
        
        for(int j=0;j<n2+1;j++){
            dp[0][j]=0;
        }
        
        return helper(n1,n2,s1,s2,dp);
    }
}