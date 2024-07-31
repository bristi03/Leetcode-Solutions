class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i=1;i<nums.length;i++){
        if(nums[i] == nums[i-1]){
            return true;
        }else if(nums[i]<nums[i-1]){
            for(int j=i-1;j>=0;j--){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
       }
       return false;
    }
}