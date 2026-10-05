class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zero=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    zero.add(new int[]{i,j});
                }
            }
        }

        for(int[] arr:zero){
            int i=arr[0];
            int j=arr[1];

            for(int k=0;k<matrix[0].length;k++){
                matrix[i][k]=0;
            }

            for(int k=0;k<matrix.length;k++){
                matrix[k][j]=0;
            }
        }
    }
}