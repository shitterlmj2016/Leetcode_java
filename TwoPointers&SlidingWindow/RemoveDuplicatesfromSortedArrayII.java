/**
 * This is a comment!
 *
 * @class: RemoveDuplicatesfromSortedArrayII
 * @description: 80. Remove Duplicates from Sorted Array II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 22:27
 **/
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9}));
    }
}
