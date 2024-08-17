class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] prev = new long[n];
        
        // Initialize the DP array for the first row
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }
        
        // Iterate over each row starting from the second one
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] curr = new long[n];
            
            // Left to Right Pass
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }
            
            // Right to Left Pass
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }
            
            // Calculate the current DP values
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            
            // Move to the next row
            prev = curr;
        }
        
        // The answer will be the maximum value in the last row
        long maxPoints = 0;
        for (long pointsAtColumn : prev) {
            maxPoints = Math.max(maxPoints, pointsAtColumn);
        }
        
        return maxPoints;
    }
}