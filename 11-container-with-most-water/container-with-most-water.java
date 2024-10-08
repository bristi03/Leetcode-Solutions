class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int len = right-left;
            int ht = Math.min(height[left], height[right]);
            int area = len*ht;
            maxArea = Math.max(area, maxArea);

            while(left < right && height[left] <= ht) left++;
            while(left < right && height[right] <= ht) right--;
        }
        return maxArea;
    }
}