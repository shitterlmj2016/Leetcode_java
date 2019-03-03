/**
 * This is a comment!
 *
 * @class: PaintHouseII
 * @description: 265. Paint House II
 * @author: Xincheng Huang - xinchenh
 * @create: 03-01-2019 23:36
 **/
public class PaintHouseII {
    public static int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int min1 = -1;
        int min2 = -1;
        for (int i = 0; i < costs.length; i++) {
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < costs[0].length; j++) {
                if (j == last1) {
                    costs[i][j] += last1 == -1 ? 0 : costs[i - 1][last2];//z注意这里错了
                } else {
                    costs[i][j] += last1 == -1 ? 0 : costs[i - 1][last1];
                }
                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[costs.length - 1][min1];
    }

    public static void main(String[] args) {
        minCostII(new int[][]{{1, 5, 3}, {2, 9, 4}});
    }
}

