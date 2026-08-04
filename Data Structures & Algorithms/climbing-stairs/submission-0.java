class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        int last = 1;
        int lastSecond = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr = last + lastSecond;
            lastSecond = last;
            last = curr;
        }

        return last;
    }
}
