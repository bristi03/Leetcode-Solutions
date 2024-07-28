class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n= nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i=0; i<n; i++){
            //if(i > 0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = n-1;
            while(left < right){
                int tempSum = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - tempSum) < Math.abs(closestSum - target)){
                    closestSum = tempSum;
                }
                if(tempSum > target)
                    right--;
                else if(tempSum < target)
                    left++;
                else
                    return tempSum;
            }
        }
        return closestSum;
    }
}