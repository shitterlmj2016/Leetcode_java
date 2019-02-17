/**
 * This is a comment!
 *
 * @class: HouseRobberII
 * @description: 213. House Robber II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-16-2019 17:05
 **/
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }

    private int dp(int[] nums, int i, int j) {
        int prev = 0;
        int curr = 0;
        for (int k = i; k < j; k++) { //T the day before yesterday, yesterday and today
            int temp = curr;
            curr = Math.max(prev + nums[k], curr);
            prev = temp;
        }
        return curr;
    }
}
