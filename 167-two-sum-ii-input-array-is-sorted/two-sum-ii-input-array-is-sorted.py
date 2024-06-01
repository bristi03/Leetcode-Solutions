class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        start = 0
        end = len(numbers) - 1
        res = [-1, -1]
        while(start < end):
            sum = numbers[start] + numbers[end]
            if(sum == target):
                res = [start+1, end+1]
                return res
            elif sum < target:
                start += 1
            else:
                end -= 1
        return res