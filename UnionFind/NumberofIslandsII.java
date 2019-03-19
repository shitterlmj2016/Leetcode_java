import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0) return res;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pair : positions
        ) {
            int position = n * pair[0] + pair[1];
            roots[position] = position;
            count++;

            for (int[] dir : dirs
            ) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];
                int neighbour = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbour] == -1)
                    continue; //不能直接和root比，会把一个不合法的位置映射到合法的位置
                neighbour = find(roots, neighbour);
                if (position != neighbour) {
                    roots[position] = neighbour;
                    position = neighbour;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
