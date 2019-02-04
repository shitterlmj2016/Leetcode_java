import java.util.Arrays;

/**
 * This is a comment!
 *
 * @class: BestTimetoBuyandSellStockIV
 * @description: Best Time to Buy and Sell Stock IV
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 22:05
 **/
public class BestTimetoBuyandSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0)
            return 0;
        k = Math.min(k, prices.length / 2);
        int[] afterBuy = new int[k];
        int[] afterSell = new int[k];

        for (int i = 0; i < k; i++) {
            afterBuy[i] = Integer.MIN_VALUE;
            afterSell[i] = 0;
        }
        //[2,1,2,0,1]

        for (int i = 0; i < prices.length; i++) {
            System.out.println(i+" :");
            for (int j = k - 1; j > 0; j--) {
                afterSell[j] = Math.max(afterSell[j], prices[i] + afterBuy[j]);
                System.out.println("C1 :"+afterSell[1]);
                afterBuy[j] = Math.max(afterBuy[j], afterSell[j - 1] - prices[i]);
                System.out.println("B1 :"+afterBuy[1]);
            }

            afterSell[0] = Math.max(afterSell[0], prices[i] + afterBuy[0]);
            System.out.println("C0 :"+afterSell[0]);
            afterBuy[0] = Math.max(afterBuy[0], -prices[i]);
            System.out.println("B0 :"+afterBuy[0]);
            System.out.println("------------------");
        }

        Arrays.sort(afterSell);
        return afterSell[afterSell.length - 1];
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 2, 0, 1};
        maxProfit(2, a);
    }

}
