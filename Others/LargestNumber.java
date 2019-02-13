import java.util.Arrays;

/**
 * This is a comment!
 *
 * @class: LargestNumber
 * @description: 179. Largest Number
 * @author: Xincheng Huang - xinchenh
 * @create: 02-13-2019 13:34
 **/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "0";
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        if (s[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String ss : s
        ) {
            sb.append(ss);
        }
        return sb.toString();
    }
}
