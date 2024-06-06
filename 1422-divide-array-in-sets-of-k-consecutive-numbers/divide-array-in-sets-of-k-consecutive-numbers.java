class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(k == 1)
            return true;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == -1) continue;
            int current = nums[i];
            if(!hasGroup(current,i, nums, k))
                return false;
        }
        return true;
    }

    boolean hasGroup(int current, int start, int[] nums, int groupSize){
        int search = current + 1;
        int count = 1;
        for(int j= start+1; j<nums.length; j++){
            if( nums[j] == search){
                search += 1;
                count += 1;
                nums[j] = -1;
            }
            if(count == groupSize)
                return true;
        }
        return false;
    }
}