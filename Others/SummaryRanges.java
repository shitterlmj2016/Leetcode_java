import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: SummaryRanges
 * @description: Summary Ranges
 * @author: Xincheng Huang - xinchenh
 * @create: 02-22-2019 12:22
 **/
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1)
                i++;
            if (i == start)
                res.add("" + nums[i] );
            else res.add(nums[start] + "->" + nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        summaryRanges(nums);
    }
}
