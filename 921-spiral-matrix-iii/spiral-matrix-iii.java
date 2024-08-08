class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Result array to store the order of visited cells
        int[][] result = new int[rows * cols][2];
        
        // Directions: right (0,1), down (1,0), left (0,-1), up (-1,0)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0; // start with 'right' direction
        
        // Initialize the starting position
        int r = rStart, c = cStart;
        int step = 0, count = 0;
        
        // Start the spiral movement
        result[count++] = new int[]{r, c};
        
        while (count < rows * cols) {
            // Increase the number of steps after two direction changes
            if (dirIndex == 0 || dirIndex == 2) {
                step++;
            }
            
            for (int i = 0; i < step; i++) {
                r += directions[dirIndex][0];
                c += directions[dirIndex][1];
                
                // Check if the new position is within the grid bounds
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count++] = new int[]{r, c};
                }
            }
            
            // Change the direction
            dirIndex = (dirIndex + 1) % 4;
        }
        
        return result;
    }
}
