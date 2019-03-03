/**
 * This is a comment!
 *
 * @class: ProductofArrayExceptSelf
 * @description: 238. Product of Array Except Self
 * @author: Xincheng Huang - xinchenh
 * @create: 02-25-2019 00:08
 **/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1)
            return nums;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp = nums[i + 1] * temp;
            dp[i] = dp[i] * temp;
        }
        return dp;
    }
}
