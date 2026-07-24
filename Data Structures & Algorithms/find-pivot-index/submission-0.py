class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        total = sum(nums)
        rsum = 0

        for i in range(len(nums)):
            if rsum * 2 + nums[i] == total:
                return i
            rsum += nums[i];
        
        return -1;