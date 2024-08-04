class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        int MOD = 1000000007;
        
        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                sums.add(currentSum);
            }
        }
        
        // Sort the sums
        Collections.sort(sums);
        
        // Calculate the sum from left to right (1-indexed)
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + sums.get(i)) % MOD;
        }
        
        return (int) result;
    }
}