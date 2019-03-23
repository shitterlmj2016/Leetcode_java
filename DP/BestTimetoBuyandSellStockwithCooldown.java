/**
 * @program: Leetcode_java
 * @description: 309. Best Time to Buy and Sell Stock with Cooldown
 * @author: Xincheng Huang
 * @create: 2019-03-23 09:29
 **/

public class BestTimetoBuyandSellStockwithCooldown {
    public static int maxProfit(int[] prices) {
        /*
        buy[i] = max(cool[i-1] - prices[i], buy[i-1] )
        cool[i] = sell[i-1];s

        buy[i] = max(sell[i-2] - prices[i], buy[i-1] )
        sell[i] = max (buy[i-1] + prices[i], sell[i-1] )

         */
        int buy = Integer.MIN_VALUE; //不然第一个buy始终是0，必须让buy比较小，不然不会买入第一笔
        int oldBuy = 0;
        int sell = 0;
        int oldSell = 0;
        for (int i = 0; i < prices.length; i++) {
            oldBuy = buy;
            buy = Math.max(oldSell - prices[i], buy);
            oldSell = sell;
            sell = Math.max(oldBuy + prices[i], sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(a));
    }
}
