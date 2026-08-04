class Solution {
    int inf = 10000;
    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int total = coinChange1(coins, amount);
        if (total >= inf)
            return -1;
        return total;
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
