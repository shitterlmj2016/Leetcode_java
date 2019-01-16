/**
 * @class: NextPermutation 技巧题目找规律，需要记忆
 * @description: 31. Next Permutation
 * @author: Xincheng Huang - xinchenh
 * @create: 01-15-2019 15:17

/**
 * 从右往左
 * 找到第一个比左边大的lo
 * 找到比lo大的hi
 * 调换lo和hi
 * lo以后逆序
 */


/**
 *  1 2 3 4
 *  1 2 4 3
 *  1 3 2 4
 *  1 3 4 2
 *  1 4 2 3
 *  1 4 3 2
 *  2 1 3 4
 */

/**
 *  1 4 3 2
 *  ^
 *  1 4 3 2
 *        ^
 *  2 4 3 1
 *  ^
 *  2 1 3 4
 */


public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int m = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                m = i;
               break;
            }
        }

        if (m == -1)//全是倒叙
        {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int n = -1;
        for (int i = nums.length - 1; i > m; i--) {
            if (nums[i] > nums[m]) {
                n = i;
                break;
            }
        }

        swap(nums,n,m);
        reverse(nums,m+1,nums.length-1);
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int [] a = {1,2,3};
        System.out.println();
    }
}
