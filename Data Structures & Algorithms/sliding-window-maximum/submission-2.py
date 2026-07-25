class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        nums1 = deepcopy(nums)
        nums2 = deepcopy(nums)

        h = [[-nums1[0], 0]]
        n = len(nums)

        for i in range(1, n):
            heapq.heappush(h, [-nums1[i], i])

            val, idx = h[0]
            while idx < i - k + 1:
                heapq.heappop(h)
                val, idx = h[0]
            
            nums1[i] = -val

        h = [[-nums2[n - 1], n - 1]]
        for i in range(n - 2, -1, -1):
            heapq.heappush(h, [-nums2[i], i])

            val, idx = h[0]
            while idx > i + k - 1:
                heapq.heappop(h)
                val, idx = h[0]
            nums2[i] = -val

        rv = []
        for i in range(0, n - k + 1):
            rv.append(max(nums2[i], nums1[i + k - 1]))

        return rv