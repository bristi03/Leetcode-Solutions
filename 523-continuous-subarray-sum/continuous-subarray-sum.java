class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //If two numbers have the same remainder when divided by k, their difference is a multiple of k.
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int mod = sum % k;
            if(map.containsKey(mod)){
                if(i- map.get(mod) >= 2) 
                    return true;
            }
            else{
                map.put(mod, i);
            }
        }
        return false;
    }
}