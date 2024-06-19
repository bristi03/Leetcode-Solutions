class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Check if it's possible to make m bouquets with k flowers each
        if ((long) m * k > bloomDay.length) {
            return -1;  // Not enough flowers
        }

        // Initialize the binary search range
        int low = 1, high = (int) 1e9;
        
        // Perform binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to make the required number of bouquets in 'mid' days
            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid;  // Try for fewer days
            } else {
                low = mid + 1;  // Need more days
            }
        }

        return low;  // The minimum number of days required
    }

    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;  // Total number of bouquets made

        // Iterate over bloomDay array
        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;  // Count of consecutive flowers bloomed by the current day
            
            // Count k consecutive bloomed flowers within the current day limit
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            // If k flowers are found, a bouquet can be made
            if (count == k) {
                total++;
                i--;  // Move back one step as the for loop will increment i again
            }

            // If required number of bouquets are made, return true
            if (total >= m) {
                return true;
            }
        }

        return false;  // Not enough bouquets can be made in 'day' days
    }
}
