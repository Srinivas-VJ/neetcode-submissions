class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n - 1;
        int res = 0;

        while (l < r) {
            res = Math.max(res, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
