import java.util.ArrayList;
import java.util.List;

/**
 * @class: Permutations
 * @description: 46. Permutations
 * @author: Xincheng Huang - xinchenh
 * @create: 01-16-2019 13:03
 **/


public class Permutations {
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        this.nums = nums;

            help(res, new ArrayList<Integer>());

        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list) {


        if (list.size() == nums.length) {
            res.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            help(res, new ArrayList<Integer> (list));
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new int[]{1,2,3});
    }
}
