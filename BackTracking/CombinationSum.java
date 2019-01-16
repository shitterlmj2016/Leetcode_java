import java.util.ArrayList;
import java.util.List;

/**
 * @class: CombinationSum
 * @description: 39. Combination Sum
 * @author: Xincheng Huang - xinchenh
 * @create: 01-15-2019 23:51
 **/
public class CombinationSum {
    int[] candidates;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        this.candidates = candidates;
        help(target, new ArrayList<Integer>(), 0);
        return res;

    }

    private void help(int target, ArrayList<Integer> list, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            help(target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }

    }
}
