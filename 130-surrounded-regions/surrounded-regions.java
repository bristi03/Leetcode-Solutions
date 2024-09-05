class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n= board[0].length;

        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){ // left
                dfs(board, i, 0); 
            }
            if(board[i][n-1]=='O'){ // right
                dfs(board, i, n-1);
            }
        }

        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){ //top
                dfs(board, 0, j);
            }
            if(board[m-1][j]=='O'){ //bottom
                dfs(board, m-1, j);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != 'O')
            return;
        board[row][col] = 'S';
        dfs(board, row+1, col);
        dfs(board, row-1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
    }
}