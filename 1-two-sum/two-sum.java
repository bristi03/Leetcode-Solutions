class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1,-1};
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                ans[0] = map.get(need);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}