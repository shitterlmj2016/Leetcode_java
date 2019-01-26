/**
 * This is a comment!
 *
 * @class: SearchinRotatedSortedArrayII
 * @description: 81. Search in Rotated Sorted Array II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-25-2019 22:04
 **/
public class SearchinRotatedSortedArrayII {
    /*
    与1的区别是数列中可能有重复的数字
    核心思想还是至少有一半是排序的
    需要注意nums[lo] == nums[hi] == nums[mid] 这种情况
        */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        // 1 1 1 3 1
        int lo = 0;
        int hi = nums.length - 1;

        // 1 x x 3 3 3 1
        while (lo + 1 < hi) //需要分别判断lo 和 hi
        {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[lo] && nums[lo] == nums[hi]) { //这里要非常小心，因为中间旋转了，需要考虑后半句
                lo++;
                hi--;
            } else if (nums[lo] <= nums[mid]) {
                if (nums[mid] < target||nums[lo]>target)
                    lo = mid;
                else hi = mid;
            } else {

                if (nums[mid] > target||nums[hi]<target) //这里要非常小心，因为中间旋转了，需要考虑后半句
                    hi = mid;
                else
                    lo = mid;
            }
        }
        if (nums[lo] == target || nums[hi] == target)
            return true;
        return false;

    }
}
