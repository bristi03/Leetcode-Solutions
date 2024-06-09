class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> modCount = new HashMap<>();
        modCount.put(0, 1); // Initialize with 0 mod seen once
        int count = 0;
        int sum = 0;
        for(int num:nums){
            sum += num;
            int mod = sum%k;
            // Adjust for negative moduli to always be positive
            if (mod < 0) 
                mod += k;
            // If mod has been seen before, add its frequency to the count
            if(modCount.containsKey(mod)){
                count += modCount.get(mod);
            }
            modCount.put(mod, modCount.getOrDefault(mod,0)+1);
        }
        return count;
    }
}