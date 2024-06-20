class Solution {
    public int maxDistance(int[] position, int m) {
        // Sort the positions
        Arrays.sort(position);
        
        // Binary search for the maximum minimum distance
        int left = 1, right = position[position.length - 1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canPlaceBalls(position, m, mid)) {
                left = mid; // Try for a larger distance
            } else {
                right = mid - 1; // Try for a smaller distance
            }
        }
        
        return left;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1; // Place the first ball in the first basket
        int lastPos = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}