class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalCount = 0;

        // Count the total number of 1s in the array
        for (int num : nums) {
            if (num == 1) {
                totalCount++;
            }
        }

        // If there are no 1s, no swaps are needed
        if (totalCount == 0) return 0;

        // Find the maximum number of 1s in any window of size totalCount
        int maxCons = 0, currentCount = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (nums[i % n] == 1) {
                currentCount++;
            }
            if (i >= totalCount) {
                if (nums[(i - totalCount) % n] == 1) {
                    currentCount--;
                }
            }
            maxCons = Math.max(maxCons, currentCount);
        }

        return totalCount - maxCons;
    }
}
