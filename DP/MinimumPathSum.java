/**
 * This is a comment!
 *
 * @class: MinimumPathSum
 * @description: 64. Minimum Path Sum
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 23:38
 **/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
//        if(grid == null||grid.length == 0||grid[0].length==0)
//            return 0;
        int len = grid[0].length;
        int[] res = new int[len];
        res[0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < len; j++) {
                if (i > 0 && j > 0) {
                    res[j] = Math.min(res[j - 1], res[j]) + grid[i][j];
                } else if (i > 0) {
                    res[j] = res[j] + grid[i][j];
                } else if (j > 0) {
                    res[j] = res[j - 1] + grid[i][j];
                }
            }
        }
        return res[len - 1];
    }


}
