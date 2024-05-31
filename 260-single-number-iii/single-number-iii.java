class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int index = 0;
        for(int i=0; i< nums.length; i++){
            if(i==0 && nums[i] != nums[i+1])
                result[index++] = nums[i];
            else if(i == nums.length-1 && nums[i] != nums[i-1])
                result[index++] = nums[i];
            else if(i>0 && nums[i] != nums[i+1] && nums[i] != nums[i-1])
                result[index++] = nums[i];
            if(index == 2)
                break;
        }
        return result;
    }
}