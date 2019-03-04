import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This is a comment!
 *
 * @class: CoinChange
 * @description: 322. Coin Change
 * @author: Xincheng Huang - xinchenh
 * @create: 03-03-2019 09:44
 **/
public class CoinChange {

    /*
    贪心：26： [419, 419, 419, 419, 419, 419, 419, 419, 408, 408, 408, 408, 186, 83, 83, 83, 83, 83, 83, 83, 83, 83, 83, 83, 83, 83]
    DP: 20: [419, 419, 419, 419, 419, 408, 408, 408, 408, 408, 408, 408, 408, 186, 186, 186, 83, 83, 83, 83]
    Let's say example [100,99,1] with amount 396. The optimal solution is obviously 4(99 * 4) but your greedy algorithm will stop and return to root from the first result 99 (100 * 3 + 1 * 96), which is not optimal. The greedy algorithm(the more bigger coins we use, the less count we need) doesn't work actually.

     */

    public int coinChange0(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;
        int dp[] = new int[amount + 1];

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] != 0 && coins[j] <= i && dp[i - coins[j]] != -1)
                    min = Math.min(min, dp[i - coins[j]] + 1);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }


    int res = 0;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;
        Arrays.sort(coins);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(coins, amount, 0, list);
        return res == 0 ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int count, ArrayList<Integer> list) {
        if (res != 0 || amount < 0)
            return;
        if (amount == 0) {
            res = count;
            System.out.println(list);
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            list.add(coins[i]);
            dfs(coins, amount - coins[i], count + 1, list);
            list.remove(list.size() - 1);
        }
    }


    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;


        ArrayList<Integer> dpCoins[] = new ArrayList[amount + 1];
        Arrays.fill(dpCoins, new ArrayList<Integer>());

        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = Integer.MAX_VALUE;
                if (coins[j] != 0 && i >= coins[j] && dp[i - coins[j]] != -1) {
                    if (dp[i - coins[j]] + 1 < min) {
                        dpCoins[i] = new ArrayList<>();
                        dpCoins[i].addAll(dpCoins[i - coins[j]]);
                        dpCoins[i].add(coins[j]);
                    }
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        Collections.sort(dpCoins[amount], (a, b) -> b - a);
        System.out.println(dpCoins[amount]);
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] c = {186, 419, 83, 408};
        coinChange2(c, 6249);
    }

}
