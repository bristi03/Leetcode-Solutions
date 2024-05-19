class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        for(int num : nums){
            total += num;
        }
        long minDiff = Integer.MAX_VALUE;
        long diff;
        long totalDiff = 0;
        int positiveCount = 0;

        for(int num: nums){
            diff = (num^k) - num;

            if(diff > 0){
                totalDiff += diff;
                positiveCount++;
            }
            minDiff = Math.min(minDiff, Math.abs(diff));
        }
        if(positiveCount % 2 == 1){
            totalDiff -= minDiff;
        }
        return total + totalDiff;
    }
}