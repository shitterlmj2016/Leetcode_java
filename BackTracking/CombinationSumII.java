import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @class: CombinationSumII
 * 40. Combination Sum II
 * 与1的区别是数组有重复，但是每个元素只能用一次。
 * @author: Xincheng Huang - xinchenh
 * @create: 01-16-2019 16:47
 **/
public class CombinationSumII {
    private int[] candidates;
    private List<List<Integer>> res;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;

        Arrays.sort(candidates);//加这一步排序

        /** 还不够
         *  1 1 2 3
         *  会有两个 1 2 3
         */


        this.candidates = candidates;
        this.target = target;
        help(new ArrayList<Integer>(), 0, 0);
        return res;

    }

    /*
     * @Author xinchenh
     * @Description
     * @Date 20:05 2019/1/16
     * @Param [list, tree, start]
     * @return void
     **/
    private void help(ArrayList<Integer> list, int sum, int start) {
        if (sum > target)
            return;
        if (sum == target) {
            if (!res.contains(list))
                res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //去重
            //1+1+2 = 4仍然会有，但是从第二个开始就跳过了
            if (i != start && candidates[i] == candidates[i - 1])
                continue;

            list.add(candidates[i]);
            help(list, sum + candidates[i], i + 1);  //i+1
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();

        System.out.println(c.combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}
