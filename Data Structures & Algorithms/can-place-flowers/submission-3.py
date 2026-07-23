class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        nums = [0] + flowerbed + [0]
        i = 1
        while (i < len(nums) - 1):
            if (nums[i] == 0 and nums[i - 1] == 0 and nums[i + 1] == 0):
                n -= 1
                i += 1
            i += 1

        return n <= 0
