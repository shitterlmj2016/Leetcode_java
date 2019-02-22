import java.util.ArrayList;
import java.util.List;

/**
 * This is a comment!
 *
 * @class: MajorityElementII
 * @description:
 * @author: Xincheng Huang - xinchenh
 * @create: 02-20-2019 23:35
 **/
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i : nums
        ) {
            if (i == candidate1)
                count1++;
            else if (i == candidate2)
                count2++;
            else if (count1 == 0) {
                candidate1 = i;
                count1++;
            } else if (count2 == 0) {
                candidate2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        //可能3-2-3这种，二不能返回
        count1 = 0;
        count2 = 0;
        for (int i : nums
        ) {
            if (i == candidate1)
                count1++;
            if (i == candidate2)
                count2++;

        }
        //0,0,0
        if (count1 > nums.length/3)
            res.add(candidate1);
        if (count2 > nums.length/3&&candidate2!=candidate1)
            res.add(candidate2);
        return res;
    }
}
