class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    char num = board[i][j];
                    if(!set.add(num + "in row" + i) || !set.add(num + "in col" + j) || !set.add(num + "in grid" + i/3 +'-' + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}