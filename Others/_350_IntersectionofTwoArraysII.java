import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Leetcode_java
 * @description: 350. Intersection of Two Arrays II
 * @author: Xincheng Huang
 * @create: 2019-04-09 11:21
 **/

public class _350_IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                res.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] ret = new int[res.size()];
        int index = 0;
        for (int i : res) {
            ret[index++] = i;
        }

        return ret;
    }
}
