class Solution {
    public int subsetXORSum(int[] nums) {
        subsetRec(nums, 0, 0);
        return xorSum;
    }
    int xorSum = 0;
    void subsetRec(int[] nums, int index, int sum){
        xorSum += sum;
        for(int i=index; i< nums.length; i++){
            subsetRec(nums, i+1, sum^nums[i]);
        }
    }
}