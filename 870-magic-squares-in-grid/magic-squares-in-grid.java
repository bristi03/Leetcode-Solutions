class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m < 3 || n < 3){
            return 0;
        }
        int count = 0;
        for(int i=0; i<= m-3; i++){
            for(int j=0; j <= n-3; j++){
                if(isValid(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    boolean isValid(int[][] grid, int row, int col) {
        // Check if the numbers are distinct and in the range 1 to 9
        boolean[] seen = new boolean[10];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Check the sums of rows, columns, and diagonals
        int targetSum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        for (int i = 0; i < 3; i++) {
            int rowSum = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
            int colSum = grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i];
            if (rowSum != targetSum || colSum != targetSum) {
                return false;
            }
        }

        int dia1Sum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int dia2Sum = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        
        if (dia1Sum != targetSum || dia2Sum != targetSum) {
            return false;
        }

        return true;
    }
}