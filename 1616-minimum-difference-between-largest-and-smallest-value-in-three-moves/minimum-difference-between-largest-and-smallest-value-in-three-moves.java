class Solution {
    public int minDifference(int[] nums) {
        // If the array has 4 or fewer elements, we can make all elements equal with at most 3 changes.
        if(nums.length <= 4)
            return 0;
        int k = 3; // We can make at most 3 changes, taken for generalization
        Arrays.sort(nums); 
        int windowSize = nums.length - k; // Size of the window of elements we will consider

        // Initialize the minimum difference with the difference of the first window
        int ans = nums[windowSize - 1] - nums[0];

        // Slide the window across the sorted array to find the minimum difference
        for(int i = 1; i <= nums.length - windowSize; i++) {
            int diff = nums[windowSize - 1 + i] - nums[i]; // Difference of current window
            ans = Math.min(ans, diff); // Update the minimum difference if the current one is smaller
        }

        return ans; 
    }
}