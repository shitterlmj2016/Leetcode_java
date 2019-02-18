import java.util.TreeSet;

/**
 * This is a comment!
 *
 * @class: ContainsDuplicateIII
 * @description: 220. Contains Duplicate III
 * @author: Xincheng Huang - xinchenh
 * @create: 02-17-2019 10:58
 **/
public class ContainsDuplicateIII {
    //TreeSet&Bucket
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Long ceil = set.ceiling((long) num - t);
            Long floor = set.floor((long) num + t);
            if ((ceil != null && ceil <= num + t) || (floor != null) && floor >= num - t)
                return true;
            set.add((long)nums[i]);
            if (i >= k)
                set.remove((long)nums[i - k]);
        }
        return false;
    }
}
