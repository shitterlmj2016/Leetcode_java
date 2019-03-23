import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Leetcode_java
 * @description: 310. Minimum Height Trees
 * @author: Xincheng Huang
 * @create: 2019-03-23 09:51
 **/

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        ArrayList<HashSet<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new HashSet<>());
        }

        for (int[] edge : edges
        ) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1)
                res.add(i);
        }

        while (n > 2) {
            List<Integer> newRes = new ArrayList<>();
            n -= res.size();
            for (int i : res
            ) {
                for (int j : map.get(i)
                ) {
                    map.get(j).remove(i);
                    if (map.get(j).size() == 1) //注意这里是1
                        newRes.add(j);
                }
            }
            res = newRes;
        }
        return res;
    }
}
