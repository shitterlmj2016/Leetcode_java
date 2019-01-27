import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: SubsetsII
 * @description: 90. Subsets II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-26-2019 10:10
 **/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        help(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            help(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
