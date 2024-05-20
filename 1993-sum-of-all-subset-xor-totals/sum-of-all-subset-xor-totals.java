class Solution {
    public int subsetXORSum(int[] nums) {
        subsetRec(nums, 0, 0);
        return xorSum;
    }
    int xorSum = 0;
    void subsetRec(int[] nums, int index, int sum){
        if(index == nums.length){
            xorSum += sum;
            return;
        }
        // Recursive call including the current element
        subsetRec(nums, index+1, sum ^ nums[index]);
        // Recursive call excluding the current element
        subsetRec(nums, index+1, sum);   
    }
}