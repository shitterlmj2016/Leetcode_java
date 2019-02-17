/**
 * This is a comment!
 *
 * @class: KthLargestElementinanArray
 * @description: Kth Largest Element in an Array
 * @author: Xincheng Huang - xinchenh
 * @create: 02-16-2019 18:21
 **/
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int lo = 0;
        int hi = nums.length - 1;
        while (true) {
            int p = partition(nums, lo, hi);
            if (p == k - 1)
                return nums[p];
            else if (p < k - 1) {
                lo = p + 1;
            } else
                hi = p - 1;
        }

    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int l = lo + 1;
        int r = hi;

        while (l <= r) { //注意是找最大的
            if (nums[l] < pivot && nums[r] > pivot)
                exch(nums, l++, r--);
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }
        exch(nums, lo, r);
        return r;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
