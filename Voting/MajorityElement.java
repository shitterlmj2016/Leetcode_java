import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: MajorityElement
 * @description: Majority Element
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 10:46
 **/
public class MajorityElement {

    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        int candidate = nums[0];
        int count = 0;
        for (int i : nums
        ) {
            if (count == 0)
                candidate = i;
            if (i == candidate)
                count++;
            else count--;
        }
        return candidate;
    }


    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                if (val + 1 > length)
                    return nums[i];
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return nums[0];//只有一个
    }
}
