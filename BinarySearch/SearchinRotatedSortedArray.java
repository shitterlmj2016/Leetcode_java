public class SearchinRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target)
                return mid;
            if (nums[lo] < nums[mid]) {
                if (nums[lo] <= target && target <= nums[mid])
                    hi = mid;
                else
                    lo = mid;
            } else {
                if (nums[hi] >= target && nums[mid] <= target)
                    lo = mid;
                else hi = mid;
            }
        }


        System.out.println(lo);
        System.out.println(hi);
        if (nums[lo] == target)
            return lo;
        else if (nums[hi] == target)
            return hi;
        else return -1;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 1, 3}, 3));
        System.out.println(3 >= 3);
    }
}
