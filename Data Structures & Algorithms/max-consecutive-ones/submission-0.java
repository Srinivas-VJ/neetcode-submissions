class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int maxOnes = 0;
        for (int n : nums) {
            if (n == 0) {
                maxOnes = Math.max(maxOnes, ones);
                ones = 0;
            } else {
                ones++;
            }
        }
        maxOnes = Math.max(maxOnes, ones);

        return maxOnes;
    }
}