class Solution {
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        
        if(mat[src[0]][src[1]]==0 || mat[dest[0]][dest[1]]==0)return -1;
        Queue<int[]> queue=new LinkedList<>();
        
        boolean[][] visited=new boolean[n][m];
        
        queue.offer(new int[]{src[0],src[1],0});
        
        visited[src[0]][src[1]]=true;
        
        int[][] directions = {
                {-1, 0}, 
                {1, 0},  
                {0, -1}, 
                {0, 1}   
        };
        
        while(!queue.isEmpty()){
            int[] cordinate=queue.poll();
            int row=cordinate[0];
            int col=cordinate[1];
            int dis=cordinate[2];
        
            if(row==dest[0] && col==dest[1]){
                return dis;
            }
            
            for(int[] direc:directions){
                int newRow=row+direc[0];
                int newCol=col+direc[1];
                
                if(newRow>=0 && newCol>=0 &&
                newRow<n && newCol<m &&
                mat[newRow][newCol]==1 &&
                !visited[newRow][newCol]){
                   
                   visited[newRow][newCol]=true;
                
                    queue.offer(new int[]{newRow,newCol,dis+1});
                
                }
                
            }
        
        }
        
        return -1;
        
    }
    
}