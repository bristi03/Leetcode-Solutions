class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to handle duplicates easily
        int maxVal = nums[nums.length - 1];
        int[] cnt = new int[maxVal + 1]; // Create a count array based on the max value in nums
        return backtrack(nums, k, 0, cnt) - 1; // Start backtracking from index 0, subtract 1 to exclude the empty subset
    }

    private int backtrack(int[] nums, int k, int start, int[] cnt) {
        int count = 1; // Start with 1 to include the current subset

        for (int i = start; i < nums.length; i++) {
            if (nums[i] - k >= 0 && cnt[nums[i] - k] > 0) {
                continue; // Skip if adding nums[i] violates the beautiful subset constraint
            }

            // Add nums[i] to the current subset
            cnt[nums[i]]++;
            // Count the current subset and recurse further
            count += backtrack(nums, k, i + 1, cnt);
            // Backtrack by removing nums[i] from the current subset
            cnt[nums[i]]--;
        }

        return count;
    }

}
