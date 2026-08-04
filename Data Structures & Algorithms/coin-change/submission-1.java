class Solution {
    int inf = 10000;
    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;

        for (int amt = 0; amt <= amount; amt++) {
            for (int coin : coins) {
                if (amt >= coin)
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }
        return dp[amount] == inf ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (cache.containsKey(amount))
            return cache.get(amount);
        if (amount == 0)
            return 0;

        int total = inf;

        for (int coin : coins) {
            if (amount >= coin)
                total = Math.min(total, 1 + coinChange1(coins, amount - coin));
        }
        cache.put(amount, total);
        return total;
    }
}
