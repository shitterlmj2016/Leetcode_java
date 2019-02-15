/**
 * This is a comment!
 *
 * @class: MinimumSizeSubarraySum
 * @description: Minimum Size Subarray Sum
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 21:42
 **/
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        /*
        2 3 1 2 4 3
         */
        if (nums == null || nums.length == 0)
            return 0;
        int min = nums.length + 1;
        int lo = 0;
        int hi = 0;
        int sum = 0;
        for (; hi < nums.length; hi++) {
            sum += nums[hi];
            while (lo <= hi && lo < nums.length && sum >= s) {
                min = Math.min(min, hi - lo + 1);
                sum -= nums[lo];
                lo++;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(15, nums));
    }
}
