class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (q.isEmpty()) {
                q.offerLast(i);
            } else {
                while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.pollLast();
                }
                q.offerLast(i);
            }
        }
        int ptr = 0;
        res[ptr++] = nums[q.peekFirst()];

        for (int i = k; i < n; i++) {
            int l = i - k;
            if (q.peekFirst() == l) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            res[ptr++] = nums[q.peekFirst()];
        }

        return res;
    }
}
