/**
 * This is a comment!
 *
 * @class: JumpGameII
 * @description: 45. Jump Game II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-22-2019 16:20
 **/
public class JumpGameII {
    //Greedy
    //You can assume that you can always reach the last index.

    /*
    核心思想：确定当前能走的最远一步
    一步步向前走，统计直到最远一步之前能走到的新的最远一步
    如果能走到终点，return res
    否则 res++， 更新为新的最远一步

    要注意循环的边界条件，可能会多加一步！！！
     */

    // 2 3 1 1 4
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int res = 0;
        int currMax = 0;
        int oldMax = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            //这里减1是如果最大块刚好是最后一块，res会++，就比正确结果大了
            currMax = Math.max(currMax, nums[i] + i);//在目标块之前所有的道路中的最大块
            if (i == oldMax) {//达到目标块了，必须选一块{
                res++;
                oldMax = currMax; //更新下一阶段的目标
            }
        }
        return res;
    }


    //BFS

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int currMax = 0;
        int oldMax = 0;
        int i = 0;
        int res = 0;

        while (oldMax - i + 1 > 0) {
            res++;
            for (; i <= oldMax; i++) {
                currMax = Math.max(nums[i] + i, currMax);
                if (currMax >= nums.length-1) //这里是length - 1;
                    return res;
            }
            oldMax = currMax;
        }
        return -1;
    }

}
