class Solution {
    int helper(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0)return grid[0][0];
        if(i<0 || j<0)return Integer.MAX_VALUE;

        if(dp[i][j]!=-1)return dp[i][j];

        int right=helper(i,j-1,grid,dp);
        int up=helper(i-1,j,grid,dp);

        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;

        if(right!=Integer.MAX_VALUE){
            a=right+grid[i][j];
        }

        if(up!=Integer.MAX_VALUE){
            b=up+grid[i][j];
        }

        return dp[i][j]=Math.min(a,b);
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(m-1,n-1,grid,dp);
    }
}