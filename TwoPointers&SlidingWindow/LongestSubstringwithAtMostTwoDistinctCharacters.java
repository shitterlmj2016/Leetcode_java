import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: LongestSubstringwithAtMostTwoDistinctCharacters
 * @description: Longest Substring with At Most Two Distinct Characters
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 10:14
 **/
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int start = 0;
        int end = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int i = s.length();
                for (int val : map.values()
                ) {
                    i = Math.min(val, i);
                }
                start = map.get(s.charAt(i));
                map.remove(s.charAt(i));
                start++;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc+"));
    }
}
