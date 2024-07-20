class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        int i=0, j=0;

        while(i < rows && j < cols){
            int x= Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = x;
            rowSum[i] -= x;
            colSum[j] -= x;
            if(rowSum[i] == 0){
                i++;
            }
            if(colSum[j] == 0){
                j++;
            }
        }
        return matrix;
    }
}