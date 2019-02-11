/**
 * This is a comment!
 *
 * @class: FindPeakElement
 * @description: 162. Find Peak Element
 * @author: Xincheng Huang - xinchenh
 * @create: 02-11-2019 00:11
 **/
public class FindPeakElement {
    //二分搜索
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] > nums[mid + 1])
                hi = mid;
            else lo = mid;
        }

        return nums[lo] > nums[hi] ? lo : hi;
    }


    //线性时间
    public int findPeakElement2(int[] nums) {
        if (nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[1] < nums[0])
                    return 0;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1])
                    return nums.length - 1;
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return -1;
    }
}
