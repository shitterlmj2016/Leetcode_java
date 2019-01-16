/**
 * @class: FindFirstandLastPositionofElementinSortedArray
 * @description: 34. Find First and Last Position of Element in Sorted Array
 * @author: Xincheng Huang - xinchenh
 * @create: 01-15-2019 20:35
 **/
public class FindFirstandLastPositionofElementinSortedArray {

    public  static int[]  searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int lo =0;
        int hi = nums.length - 1;
        int index = -1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (target < nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        if (index == -1)
            return new int[]{-1, -1};

        int i = index;
        int j = index;

        while (i - 1 >= 0 && nums[i - 1] == target)
            i--;
        while (j + 1 < nums.length && nums[j + 1] == target)
            j++;
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{1,1,2},1));
    }
}
