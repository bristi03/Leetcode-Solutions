class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1; //left cumulative products
        for(int i=0; i<nums.length; i++){
            res[i] = left;
            left *= nums[i];
        }

        int right = 1; //right cumulative products
        for(int j = nums.length-1; j>=0; j--){
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}