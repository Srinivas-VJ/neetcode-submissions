class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (total % 2 == 1)
            return false;

        total /= 2;
        boolean[][] dp = new boolean[n + 1][total + 1];
        dp[n][0] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 0; sum <= total; sum++) {
                boolean take = false;
                if (sum >= nums[i])
                    take = dp[i + 1][sum - nums[i]];
                boolean leave = dp[i + 1][sum];
                dp[i][sum] = take || leave;
            }
        }
        return dp[0][total];
    }

    private boolean solve(int[] nums, int i, int sum) {
        if (i == nums.length)
            return sum == 0;
        
        if (sum == 0)
            return true;
        
        if (sum < 0)
            return false;
        
        // take
        boolean take = solve(nums, i + 1, sum - nums[i]);
        
        // not take
        boolean not = solve(nums, i + 1, sum);

        return take || not;
    }
}
