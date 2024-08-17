class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int prefixMin = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= prefixMin){
                prefixMin = nums[i];
            }
            else{
                int diff = nums[i] - prefixMin;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        return maxDiff;
    }
}