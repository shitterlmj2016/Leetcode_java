import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode_java
 * @description: Shortest Distance from All Buildings
 * @author: Xincheng Huang
 * @create: 2019-04-08 10:21
 **/

public class _317_ShortestDistancefromAllBuildings {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;

        int[][] nums = new int[m][n];
        int[][] dist = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, nums, dist, new int[]{i, j});
                    count++;
                }
            }
        }

        return find(grid, nums, dist, count);
    }

    private int find(int[][] grid, int[][] nums, int[][] dist, int count) {
        int m = grid.length;
        int n = grid[0].length;
        Integer min = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && nums[i][j] == count) {
                    min = min == null ? dist[i][j] : Math.min(dist[i][j], min);
                }
            }
        }
        return null == min ? -1 : min;
    }

    private void bfs(int[][] grid, int[][] nums, int[][] dist, int[] pos) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos);
        int steps = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            steps++;
            for (int i = 0; i < count; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs
                ) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        dist[x][y] += steps;
                        visited[x][y] = true;
                        nums[x][y] += 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
