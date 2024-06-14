class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= nums[i-1]){
                int dif = nums[i-1] - nums[i];
                nums[i] += dif + 1;
                count += dif + 1;
            }
        }
        return count;
    }
}