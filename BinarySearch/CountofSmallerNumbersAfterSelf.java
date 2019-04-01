import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Leetcode_java
 * @description: 315. Count of Smaller Numbers After Self
 * @author: Xincheng Huang
 * @create: 2019-03-24 11:26
 **/
  /*
  2 2 1
   */
public class CountofSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        // [6,2,6,1]
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = helper(list, nums[i]);
            list.add(index, nums[i]);  //注意这里是add不是set
            res[i] = index;
        }
        return Arrays.asList(res);
    }

    private static int helper(ArrayList<Integer> list, int num) {
        if (list.size() == 0) return 0;
        int lo = 0;
        int hi = list.size() - 1;
        if (list.get(lo) >= num) return 0;
        if (list.get(hi) < num) return list.size();

//        while (lo + 1 < hi) {
//            int mid = (hi - lo) / 2 + lo;
//            if (list.get(mid) >= num) hi = mid;    //这边是大于等于
//            else if (list.get(mid) < num) lo = mid;  //注意别忘了else
//            else return mid;
//        }

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (list.get(mid) < num)
                lo = mid + 1;
            else hi = mid;
        }

        if (list.get(lo) >= num) return lo;
        return hi;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new int[]{1, 2, 3}));
        System.out.println("1231 123".split(" ")[0]);
    }
}
