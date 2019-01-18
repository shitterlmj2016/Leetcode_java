/**
 * This is a comment!
 *
 * @class: FirstMissingPositive
 * @description: 41. First Missing Positive
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 19:17
 **/
public class FirstMissingPositive {


    /*
    桶排序问题 对应位置放对应的数
     第i个位置放 i+1
     0 1 2 3
     1 2 3 4
     1 2 -1 4
          ^本来应该放三
     1 2 99 4

     3 1 4 2
     ^
     nums[0] = 3
     nums[2]!= 3

     4 1 3 2
     ^
     2 1 3 4
     ^
     1 2 3 4




第一步，所有在范围内的数和自己所属位置上的数调换
switch(nums[nums[i] - 1], nums[i])

     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            //注意这里是小于等于
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {//<=
                int temp = nums[nums[i] - 1];
                //交换顺序不能变，不能先改nums[1]，不然nums[nums[i] - 1]位置就变了
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;


    }

    public static void main(String[] args) {
        System.out.println();
    }
}
