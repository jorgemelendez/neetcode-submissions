class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        max_profit = 0
        
        low_price = 10001
        for i in range(len(prices)):
            if prices[i] <= low_price:
                low_price = prices[i]
                continue
            
            max_profit = max_profit + prices[i] - low_price
            low_price = prices[i]


        return max_profit