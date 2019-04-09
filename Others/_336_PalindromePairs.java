import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Leetcode_java
 * @description:
 * @author: Xincheng Huang
 * @create: 2019-04-09 09:14
 **/

public class _336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                String s1 = s.substring(0, j);
                String s2 = s.substring(j);
                if (isPalindrome(s1)) {
                    String s2_rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2_rev) && map.get(s2_rev) != i) {
                        res.add(Arrays.asList(new Integer[]{map.get(s2_rev), i}));
                    }
                }
                if (s2.length() != 0 && isPalindrome(s2)) {
                    String s1_rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1_rev) && map.get(s1_rev) != i) {
                        res.add(Arrays.asList(new Integer[]{i, map.get(s1_rev)}));
                    }
                }
            }
        }
        return res;
    }


    private boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length()-1 ;
        while (lo <= hi) {
            char c1 = s.charAt(lo);
            char c2 = s.charAt(hi);
            if (c1 != c2) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
