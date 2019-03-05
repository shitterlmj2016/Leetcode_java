/**
 * This is a comment!
 *
 * @class: MoveZeroes
 * @description: 283. Move Zeroes
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 20:09
 **/
public class MoveZeroes {

    /*
    1 3 0 7 0 2
    ^ ^ ^ ^
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            nums[slow] = nums[fast];
            fast++;
            if (nums[slow] != 0)
                slow++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
