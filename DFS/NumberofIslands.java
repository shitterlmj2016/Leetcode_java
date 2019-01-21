/**
 * This is a comment!
 *
 * @class: NumberofIslands
 * @description: 200. Number of Islands
 * @author: Xincheng Huang - xinchenh
 * @create: 01-19-2019 00:25
 **/


/*
每次扫描到1，就把和他连接的都变为0，然后总数加1

11110         00000         00000
11010  (0) -> 00010 (1) ->  00000 (2)
11000         00000         00000
00000         00000         00000



 */
public class NumberofIslands {

    int m;
    int n;


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m >= this.m || n >= this.n || grid[m][n] == '0')
            return;
        grid[m][n] = '0';

        dfs(grid, m - 1, n);
        dfs(grid, m + 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m, n + 1);
    }
}
