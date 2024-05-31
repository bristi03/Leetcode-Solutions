class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        
        int[] result = new int[2];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        
        return result;
    }
}