class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] ans = {-1,-1};
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum < target){
                start++;
            }
            else if(sum > target){
                end--;
            }
            else{
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            }
        }
        return ans;
    }
}