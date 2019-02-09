/**
 * This is a comment!
 *
 * @class: MaximumProductSubarray
 * @description: Maximum Product Subarray
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 14:54
 **/
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int oldMin = min;
            int oldMax = max;
            min = Math.min(Math.min(oldMax * nums[i], oldMin * nums[i]), nums[i]);
            max = Math.max(Math.max(oldMax * nums[i], oldMin * nums[i]), nums[i]);
            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
