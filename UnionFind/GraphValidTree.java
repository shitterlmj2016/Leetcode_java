import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree {
    //261. Graph Valid Tree

    //union-find
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0)
            return true;
        if (n < 1 || edges.length != n - 1)
            return false;
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int[] edge : edges
        ) {
            int left = find(roots, edge[0]);
            int right = find(roots, edge[1]);
            if (left == right) return false;
            roots[left] = right;
        }
        return true;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }


    //DFS
    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);//这步很重要
        }
        HashSet<Integer> visited = new HashSet<>();

        visited.add(0);//这步很重要

        if (!helper(graph, visited, 0, -1))
            return false;

        return visited.size() == n;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> set, int curr, int prev) {
        List<Integer> list = graph.get(curr);
        for (int i : list) {
            if (i == prev) continue;
            if (set.contains(i)) return false;
            set.add(i);
            if (!helper(graph, set, i, curr)) return false; //不能直接return结果，每一个都需要判断是不是错的
        }
        return true;
    }


    public static void main(String[] args) {
        GraphValidTree g = new GraphValidTree();
        g.validTree(2, new int[][]{{0, 1}});
    }

}
