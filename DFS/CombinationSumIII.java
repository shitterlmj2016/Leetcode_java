import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: CombinationSumIII
 * @description: Combination Sum III
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 10:18
 **/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), k, n, 0); //从0开始，下面要加一
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int start) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start + 1; i <= n && i < 10; i++) {
            list.add(i);
            dfs(res, list, k - 1, n - i, i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
