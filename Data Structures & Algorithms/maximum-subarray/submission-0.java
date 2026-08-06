class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = -1000000000;
        int max = maxSoFar;

        for (int n : nums) {
            maxSoFar = Math.max(n, n + maxSoFar);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
