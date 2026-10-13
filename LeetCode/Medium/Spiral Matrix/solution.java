class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> li = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int row = 0;
        int col = 0;

        int total = rows * cols;
        int visitedCount = 0;

        while (visitedCount < total) {

         
            while (col < cols && !visited[row][col]) {
                li.add(matrix[row][col]);
                visited[row][col] = true;
                visitedCount++;
                col++;
            }

            col--;      
            row++;      

            while (row < rows && !visited[row][col]) {
                li.add(matrix[row][col]);
                visited[row][col] = true;
                visitedCount++;
                row++;
            }

            row--;
            col--;    
            
            while (col >= 0 && !visited[row][col]) {
                li.add(matrix[row][col]);
                visited[row][col] = true;
                visitedCount++;
                col--;
            }

            col++;
            row--;      

            while (row >= 0 && !visited[row][col]) {
                li.add(matrix[row][col]);
                visited[row][col] = true;
                visitedCount++;
                row--;
            }

            row++;
            col++;       
        }

        return li;
    }
}