class Solution {
public:
    vector<vector<int>> restoreMatrix(vector<int>& rowSum, vector<int>& colSum) {
        int rows = rowSum.size();
        int cols = colSum.size();
        std::vector<std::vector<int>> matrix(rows, std::vector<int>(cols, 0));
        int i = 0, j = 0;

        while (i < rows && j < cols) {
            int x = std::min(rowSum[i], colSum[j]);
            matrix[i][j] = x;
            rowSum[i] -= x;
            colSum[j] -= x;
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        return matrix;
    }
};