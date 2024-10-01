class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        k = k%n;
        k = n-k;
        int[] temp = new int[k];
        for(int i=0; i<k; i++){
            temp[i] = nums[i];
        }
        int idx = 0;
        for(int i=k; i<nums.length; i++){
            nums[idx++] = nums[i];
        }
        for(int i=0; i<k; i++){
            nums[idx++] = temp[i];
        }
    }
}