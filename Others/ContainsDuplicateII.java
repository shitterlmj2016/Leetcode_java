import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: ContainsDuplicateII
 * @description: Contains Duplicate II
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 10:38
 **/
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int a []= {2,2};
        System.out.println(containsNearbyDuplicate(a,3));
    }
}
