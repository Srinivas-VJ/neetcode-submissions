class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        prev = nums[0]
        maxCount = 0
        count = 1

        for i in range(1, len(nums)):
            if nums[i] > prev:
                count += 1
            else:
                maxCount = max(maxCount, count)
                count = 1
            prev = nums[i]

        maxCount = max(maxCount, count)

        prev = nums[0]
        count = 1

        for i in range(1, len(nums)):
            if nums[i] < prev:
                count += 1
            else:
                maxCount = max(maxCount, count)
                count = 1
            prev = nums[i]
        
        maxCount = max(maxCount, count)


        return maxCount

