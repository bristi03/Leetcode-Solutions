class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> mpp = new HashMap<>();
        int[] ans = new int[2];
        ans[0]= ans[1] =-1;

        for(int i=0; i<nums.length; i++){
            int more = target - nums[i];
            if(mpp.containsKey(more)){
                ans[0] = mpp.get(more);
                ans[1] = i;
                return ans;
            }
            mpp.put(nums[i],i);
        }
        return ans;
    }
}