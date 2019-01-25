/**
 * This is a comment!
 *
 * @class: UniquePathsII
 * @description: 63. Unique Paths II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-23-2019 23:32
 **/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid[0].length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < len; j++) {
                if (obstacleGrid[i][j] == 1) //这一步保证了如果第一格就有障碍，就返回0；
                    res[j] = 0;
                else {
                    if(j>0)
                        res[j] = res[j]+res[j-1];
                }
            }
        }
        return res[len - 1];
    }
}
