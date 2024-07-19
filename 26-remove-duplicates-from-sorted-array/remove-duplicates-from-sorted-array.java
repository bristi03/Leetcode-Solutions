class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int num: nums){
            if(set.add(num)){
                nums[index++] = num;
            }
        }
        return index;
    }
}