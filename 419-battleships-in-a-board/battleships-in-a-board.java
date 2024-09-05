class Solution {
    public int countBattleships(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'X'){
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int row, int col){
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != 'X')
            return;
        board[row][col] = '-';
        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }
}