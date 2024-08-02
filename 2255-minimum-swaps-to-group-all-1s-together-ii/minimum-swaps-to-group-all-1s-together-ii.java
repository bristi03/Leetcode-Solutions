class Solution {
    public int minSwaps(int[] nums) {
        int n= nums.length;
        int totalCount = 0;
        int currCons = 0;
        int maxCons = 0;
        for(int num:nums){
            if(num == 1)
                totalCount++;
        }
        for(int i=0; i< 2*n; i++){
            if(nums[i%n] == 1){
                currCons++;
            }
            if(i >= totalCount){
                if(nums[(i-totalCount) % n]==1){
                    currCons--;
                }
                maxCons = Math.max(maxCons, currCons);
            }
        }
        return totalCount - maxCons;
    }
}