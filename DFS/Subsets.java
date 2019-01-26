import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: Subsets
 * @description: 78. Subsets
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 21:33
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        help(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int start, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            help(res, list, i + 1, nums);//这里是i+1，不是start+1；
            list.remove(list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1, 2, 3}));
    }
}




