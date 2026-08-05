class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[amount + 1][coins.length];
        return solve(coins, amount, 0);
    }

    private int solve(int[] coins, int amount, int i) {
        if (i == coins.length) {
            return amount == 0 ? 1 : 0;
        }

        if (dp[amount][i] != null)
            return dp[amount][i];

        int combs = 0;
        int orgAmt = amount;
        while (coins[i] <= amount) {
            combs += solve(coins, amount - coins[i], i + 1);
            amount -= coins[i];
        }
        combs += solve(coins, orgAmt, i + 1);

        return dp[orgAmt][i] = combs;
    }
}
