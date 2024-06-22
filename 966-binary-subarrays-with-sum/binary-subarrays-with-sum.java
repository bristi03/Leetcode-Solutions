class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;

        // Keep track of how many times we've seen a prefix sum
        // equal to a certain value
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);  // Empty subarray with sum 0

        for (int num : nums) {
            sum += num;

            // Count the number of subarrays ending at the current index
            // with a sum equal to the goal
            count += prefixSums.getOrDefault(sum - goal, 0);

            // Update the count of prefix sums seen so far
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}