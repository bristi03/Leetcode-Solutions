class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) // k+1 = 4
            return 0;
        int k = 3;
        Arrays.sort(nums);
        int windowSize = nums.length - k;
        int ans = nums[windowSize-1] - nums[0];
        for(int i=1; i<= nums.length- windowSize; i++){
            int diff = nums[windowSize - 1 + i] - nums[i];
            ans = Math.min(ans,diff);
        }
        return ans;
    }
}