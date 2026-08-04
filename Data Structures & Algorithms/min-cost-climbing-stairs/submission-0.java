class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prevCost = cost[1];
        int prevPrevCost = cost[0];

        for (int i = 2; i < n; i++) {
            int c = Math.min(prevCost, prevPrevCost);
            prevPrevCost = prevCost;
            prevCost = c + cost[i];
        }

        return Math.min(prevCost, prevPrevCost);
    }
}
