/**
 * This is a comment!
 *
 * @class: FindMinimuminRotatedSortedArray
 * @description: Find Minimum in Rotated Sorted Array
 * @author: Xincheng Huang - xinchenh
 * @create: 02-08-2019 23:28
 **/
public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] < nums[hi])
                hi = mid;
            else
                lo = mid;
        }
        return Math.min(nums[lo], nums[hi]);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 7, 8, 9, 0, 1, 2};
        System.out.println(findMin(a));
    }
}
