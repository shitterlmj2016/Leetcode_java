/**
 * This is a comment!
 *
 * @class: BestTimetoBuyandSellStockII
 * @description: 122. Best Time to Buy and Sell Stock II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 21:15
 **/
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0)
                res += profit;
        }
        return res;
    }
}
