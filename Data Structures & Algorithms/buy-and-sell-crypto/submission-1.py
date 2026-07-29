class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minSoFar = prices[0];
        maxProfit = 0;

        for price in prices:
            maxProfit = max(maxProfit, price - minSoFar);
            minSoFar = min(minSoFar, price);

        
        return maxProfit;
        