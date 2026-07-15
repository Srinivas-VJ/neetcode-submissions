class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size * 2];

        for (int i = 0; i < ans.length; i++)
            ans[i] = nums[i % size];

        return ans;
    }
}