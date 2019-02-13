import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: MissingRanges
 * @description: 163. Missing Ranges
 * @author: Xincheng Huang - xinchenh
 * @create: 02-12-2019 20:25
 **/
public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long llower = (long) lower, lupper = (long) upper;
        List<String> res = new ArrayList<>();
        for (int i : nums
        ) {
            // 0   99
            //  7
            if (llower == i) {
                llower++;
            } else if (llower < i) {
                if (llower + 1 == i)
                    res.add(String.valueOf(llower));
                else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(llower);
                    sb.append("->");
                    sb.append(i - 1);
                    res.add(sb.toString());
                }
                llower = (long) i;
            }
        }

        if (llower < upper - 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(llower);
            sb.append("->");
            sb.append(lupper);
            res.add(sb.toString());
        }
        if (llower + 1 == lupper) {
            res.add(lower + "->" + lupper);
        }
        if (llower == lupper)
            res.add(String.valueOf(lupper));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        findMissingRanges(nums, 0, 99);
    }
}
