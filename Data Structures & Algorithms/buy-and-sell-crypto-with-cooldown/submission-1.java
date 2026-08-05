class Solution {
    Map<String, Integer> cache = new HashMap<>();

    public int maxProfit(int[] prices) {
        return solve(prices, 0, false);
    }

    private int solve(int[] prices, int i, boolean holding) {
        var key = i + " " + holding;
        if (cache.containsKey(key))
            return cache.get(key);

        if (i >= prices.length)
            return 0;

        // buy 
        int buy = !holding ? solve(prices, i + 1, true) - prices[i] : 0;

        // sell
        int sell = holding ? solve(prices, i + 2, false) + prices[i] : 0;

        // hold
        int hold = solve(prices, i + 1, holding);

        cache.put(key,  Math.max(hold, Math.max(buy, sell)));
        return cache.get(key);
    }
}
