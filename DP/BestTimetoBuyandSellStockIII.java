/**
 * This is a comment!
 *
 * @class: BestTimetoBuyandSellStockIII
 * @description: Best Time to Buy and Sell Stock III
 * @author: Xincheng Huang - xinchenh
 * @create: 01-29-2019 21:31
 **/
public class BestTimetoBuyandSellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int price : prices
        ) {

            secondSell = Math.max(secondSell, price + secondBuy);//越大则最终转的越大
            secondBuy = Math.max(secondBuy, firstSell - price);//越大则第一笔赚的越大
            firstSell = Math.max(firstSell, price + firstBuy); //第一次赚的钱
            firstBuy = Math.max(firstBuy, -price);//第一次买剩下的钱，一定是负数，最便宜时候下手
        }
        return secondSell;
    }


    public static int maxProfit2(int[] prices) {
        if (prices == null)
            return 0;
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        int i =0;
        for (int price : prices
        ) {
            System.out.println(i++);
            //最终手头剩下的钱
            secondSell = Math.max(secondSell, price + secondBuy);//第二次卖出的钱加上第一次纂下的钱
            System.out.println("C1 :" + secondSell);
            //第二次买入后手上剩下的钱
            secondBuy = Math.max(secondBuy, firstSell - price);//最低价格买入（剩下最多的钱）

            System.out.println("B1 :" + secondBuy);
            //第一次卖出之后手头剩下的钱
            firstSell = Math.max(firstSell, price + firstBuy); //最大价格卖出
            System.out.println("C0 :" + firstSell);
            //第一次买入以后手头（欠）下的钱
            firstBuy = Math.max(firstBuy, -price);//最低价买入
            System.out.println("B0 :" + firstBuy);
            System.out.println("------------------");
        }
        return secondSell;
    }

    public static void main(String[] args) {
        int a[] = {2, 1, 2, 0, 1};
        System.out.println(maxProfit2(a));
    }
}
