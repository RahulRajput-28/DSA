class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int min=0;

        while(!queue.isEmpty() && fresh > 0){

            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] arr= queue.poll();

            int row=arr[0];
            int col=arr[1];

            if(row-1>=0 && grid[row-1][col]==1){
                queue.add(new int[]{row-1,col});
                grid[row-1][col]=2;
                fresh--;
            }

            if(row+1<grid.length && grid[row+1][col]==1){
                queue.add(new int[]{row+1,col});
                grid[row+1][col]=2;
                fresh--;
            }

            if(col-1>=0 && grid[row][col-1]==1){
                queue.add(new int[]{row,col-1});
                grid[row][col-1]=2;
                fresh--;
            }

            if(col+1<grid[0].length && grid[row][col+1]==1){
                queue.add(new int[]{row,col+1});
                grid[row][col+1]=2;
                fresh--;
            }
            }
            
            min++;
        }

        if(fresh>0){
            return -1;
        }

        return min;
    }
}