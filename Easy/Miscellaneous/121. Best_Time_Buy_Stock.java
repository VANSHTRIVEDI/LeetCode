package Easy.Miscellaneous;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//Imp Question
class Solution {
    public int maxProfit(int[] prices) {
        int min, max, profit = 0, maxprofit = 0;
        min = prices[0];
        max = prices[0];
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] <= min) {
                min = prices[i + 1];
                max = prices[i + 1];
            } else if (prices[i + 1] > min) {
                max = prices[i + 1];

            }
            profit = max - min;
            if (profit > maxprofit) {
                maxprofit = profit;
            }

        }
        return maxprofit;
    }
}
