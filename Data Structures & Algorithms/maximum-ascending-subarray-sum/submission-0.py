class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        maxSum = 0
        sum = 0
        prev = 0

        for num in nums:
            if num > prev:
                sum += num
            else:
                maxSum = max(maxSum, sum)
                sum = num
            prev = num
        
        maxSum = max(maxSum, sum)

        return maxSum

        