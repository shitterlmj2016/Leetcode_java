/**
 * This is a comment!
 *
 * @class: HouseRobber
 * @description: 198. House Robber
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 20:49
 **/
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int theDayBeforeYesterday = 0;
        int yesterday = 0;
        int today = 0;

        for (int i = 0; i < nums.length; i++) {
            today = Math.max(theDayBeforeYesterday + nums[i], yesterday);
            theDayBeforeYesterday = yesterday;
            yesterday = today;
        }
        return today;
    }
}
