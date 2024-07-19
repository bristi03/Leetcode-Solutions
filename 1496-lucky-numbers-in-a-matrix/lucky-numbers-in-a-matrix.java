class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i< matrix.length; i++){
            int min = matrix[i][0];
            int col = 0;
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    col = j;
                }
            }
            if(isMaxCol(min, col, matrix)){
                res.add(min);
            }
        }
        return res;
    }

    private boolean isMaxCol(int val, int col, int[][] matrix){
        for(int i=0; i< matrix.length; i++){
            if(matrix[i][col] > val)
                return false;
        }
        return true;
    }
}