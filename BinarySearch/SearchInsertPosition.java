/**
 * @class: SearchInsertPosition
 * @description: 35. Search Insert Position
 * @author: Xincheng Huang - xinchenh
 * @create: 01-15-2019 20:54
 **/
public class SearchInsertPosition {

    public static int  searchInsert(int[] nums, int target) {


        if (nums == null || nums.length == 0)
            return -1;


        if ( nums[nums.length-1] < target)
            return nums.length;

        int lo = 0;
        int hi = nums.length - 1;
        int mid = (hi - lo) / 2 + lo;
        while (lo +1< hi) {
            mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid])
                hi = mid;
            else
                lo = mid ;
        }

        System.out.println(lo);
        System.out.println(hi);

        int min = Math.min(lo,hi);
        int max = Math.max(lo,hi);

        // target__target__target
        if(target<=nums[min])
            return min;
        if(target<=nums[max])
            return max;
        return ++max;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6},0));
    }
}
