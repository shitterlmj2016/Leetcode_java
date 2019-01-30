/**
 * This is a comment!
 *
 * @class: BestTimetoBuyandSellStock
 * @description: 121. Best Time to Buy and Sell Stock
 * @author: Xincheng Huang - xinchenh
 * @create: 01-28-2019 23:37
 **/
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int res = 1;
        while (true) {

            System.out.println(res*=2);
        }
    }
}
