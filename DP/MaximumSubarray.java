/**
 * DP 问题
 *
 * @class: MaximumSubarray
 * @description: 53. Maximum Subarray
 * @author: Xincheng Huang - xinchenh
 * @create: 01-18-2019 00:16
 **/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; //
        //  int res = 0; 错了，只有一个的时候就返回0了
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {

            dp[i] = dp[i - 1] < 0 ? nums[i] : nums[i] + dp[i - 1]; //重点！！：加上负数肯定比自身小

            res = Math.max(dp[i], res);
        }

        return res;
    }


}
