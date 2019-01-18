/**
 * @class: PermutationsII
 * @description: 47. Permutations II
 * @author: Xincheng Huang - xinchenh
 * @create: 01-16-2019 22:56
 **/

//去重！！！

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 与1不同的是可能有重复的
 * 用一个boolean数组记录是否用过这个数
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return list;

        Arrays.sort(nums);//去重要先排序

        help(nums, list, new ArrayList<Integer>(), new boolean[nums.length]);
        return list;

    }

    private void help(int[] nums, List<List<Integer>> list, ArrayList<Integer> integers, boolean[] booleans) {

        if (integers.size() == nums.length) {
            list.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (booleans[i] || i > 0 && nums[i] == nums[i - 1] && !booleans[i - 1])
            /**
             * !booleans[i - 1] 和 booleans[i - 1] 都可以
             * Code 1 makes sure when duplicates are selected, the order is ascending (index from small to large).
             * However, code 2 means the descending order.﻿
             *
             */
                continue;
            integers.add(nums[i]);
            booleans[i] = true;
            help(nums, list, integers, booleans);
            booleans [i] = false;  // 这句要注意！！！ 因为内存中只有一个，你改了就一直变了
            integers.remove(integers.size() - 1);
        }

    }


}
