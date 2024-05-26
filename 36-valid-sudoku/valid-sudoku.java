class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            int[] row = new int[9];
            int[] col = new int[9];
            int[] block = new int[9];

            for(int j=0; j<9; j++){
                //check in row
                if(board[i][j] != '.'){
                    int n = board[i][j] - '1';
                    if(row[n] == 0)
                        row[n]++;
                    else
                        return false;
                }
                //check in col
                if(board[j][i] != '.'){
                    int n = (board[j][i]) - '1';
                    if(col[n] == 0)
                        col[n]++;
                    else
                        return false;
                }
               // Check in block
                int blockRow = 3 * (i / 3) + j / 3;
                int blockCol = 3 * (i % 3) + j % 3;
                if (board[blockRow][blockCol] != '.') {
                    int num = board[blockRow][blockCol] - '1';
                    if (block[num] == 0)
                        block[num]++;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}