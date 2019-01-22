/**
 * This is a comment!
 *
 * @class: JumpGame
 * @description: 55. jump game
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 16:07
 **/

//贪心
//数组中表示最大能跳几步
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0; //最大能走到的位置
        for (int i = 0; i < nums.length; i++) {
            if (max < i)
                return false;
            max = Math.max(max,i+nums[i]);//祖传的最大位置 vs 新的最大位置
        }
        return true;

        //0 的时候return true；
    }
}
