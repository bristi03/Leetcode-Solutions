class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int sum=0, count=0;
        for(int num:nums){
            sum += num;
            // Count the number of subarrays ending at the current index
            // with a sum equal to the goal
            count += prefixSum.getOrDefault(sum-k, 0);

            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}