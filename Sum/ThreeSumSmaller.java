import java.util.Arrays;

/**
 * This is a comment!
 *
 * @class: ThreeSumSmaller
 * @description: 3Sum Smaller
 * @author: Xincheng Huang - xinchenh
 * @create: 03-03-2019 00:02
 **/
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        Arrays.sort(nums);

        /*
        3
        -1 0 1 1 2 4 5
         */

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] >= target)
                    hi--;
                else {
                    res += hi - lo;
                    lo++;
                }
            }

        }
        return res;

    }
}