class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        left = 0
        right = len(height)-1
        while(left < right):
            l = right - left
            ht = min(height[left], height[right])
            area = l*ht
            maxArea = max(maxArea, area)
            while(left < right and height[left] <= ht):
                left += 1
            while(left < right and height[right] <= ht):
                right -= 1

        return maxArea
        