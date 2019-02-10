import java.util.HashMap;

/**
 * This is a comment!
 *
 * @class: LongestSubstringwithAtMostKDistinctCharacters
 * @description: Longest Substring with At Most K Distinct Characters
 * @author: Xincheng Huang - xinchenh
 * @create: 02-10-2019 10:54
 **/
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0)
            return 0;

        int start = 0;
        int end = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.size() <= k) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > k) {
                int i = s.length();
                for (int j : map.values()
                ) {
                    i = Math.min(j, i);
                }
                start = i + 1;
                map.remove(s.charAt(i));
            }
            res = Math.max(res, end - start);
        }
        return res;
    }
}
