/**
 * This is a comment!
 *
 * @class: PaintHouse
 * @description: Paint House
 * @author: Xincheng Huang - xinchenh
 * @create: 03-01-2019 16:45
 **/
public class PaintHouse {
    /*
    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
    Minimum cost: 2 + 5 + 3 = 10.
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int len = costs.length;
        int dp[][] = new int[len][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }
}
